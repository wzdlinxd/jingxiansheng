package com.linxd.controller;

import com.linxd.bean.vo.account.LoginVo;
import com.linxd.entity.Account;
import com.linxd.entity.Result;
import com.linxd.service.AccountService;
import com.linxd.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/13 16:00
 * Description: No Description
 */
@RestController
public class LoginController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 登陆认证
     * @param vo
     * @return
     */
    @GetMapping("/login")
    public Result<Map<String,String>> login(@RequestBody LoginVo vo) {
        if (StringUtils.isEmpty(vo.getAccount()) || StringUtils.isEmpty(vo.getPassword())) {
            return new Result<>(400, null, "参数出错");
        }
        String account = vo.getAccount();
        String password = vo.getPassword();
        //查询用户
        Account user = accountService.selectByAccount(account,vo.getRole());

        if(user!= null && user.getAccount().equals(account) && user.getPassword().equals(password)){
            //生成token
            String token = JWTUtil.generateToken(user.getId().toString());
            //生成refreshToken
            String refreshToken = UUID.randomUUID().toString().replaceAll("-","");

            //放入redis
            redisTemplate.opsForHash().put(refreshToken, "token", token);
            redisTemplate.opsForHash().put(refreshToken, "accId", user.getId().toString());
            //设置token的过期时间
            redisTemplate.expire(refreshToken, JWTUtil.REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);

            Map<String,String> map = new HashMap<String,String>(2);
            map.put("token", token);
            map.put("refreshToken", refreshToken);
            return new Result<>(200, map, "登陆成功");

        }

        return new Result<>(400, null, "登陆失败");
    }

    /**
     * 登出
     * @param refreshToken
     * @return
     */
    @GetMapping("/logout")
    public Result<String> logout(String refreshToken) {
        redisTemplate.opsForHash().delete(refreshToken);
        return new Result<>(200, null, "登出成功");
    }

    /**
     * 刷新token
     * @param refreshToken
     * @return
     */
    @GetMapping("/refreshToken")
    public Result<Map<String,String>> refreshToken(@RequestParam String refreshToken) {
        String accId = (String)redisTemplate.opsForHash().get(refreshToken, "accId");
        if(StringUtils.isEmpty(accId)){
            return new Result<>(400, null, "refreshToken error");
        }

        //生成新的token
        String newToken = JWTUtil.generateToken(accId);
        redisTemplate.opsForHash().put(refreshToken, "token", newToken);

        Map<String,String> map = new HashMap<String,String>(2);
        map.put("token", newToken);
        map.put("refreshToken", refreshToken);
        return new Result<>(200, map, "刷新成功");
    }
}
