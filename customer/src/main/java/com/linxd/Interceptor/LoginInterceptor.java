package com.linxd.Interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.linxd.bean.entity.Account;
import com.linxd.service.AccountService;
import com.linxd.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/14 15:14
 * Description: No Description
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("目标方法执行前执行");
        String token = httpServletRequest.getHeader("token");
        String refreshToken = httpServletRequest.getHeader("refreshToken");
        // 如果不是映射到方法直接通过
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        if (token == null) {
            return false;
        }
        String accId = JWTUtil.getAccount(token);
        if (StringUtils.isEmpty(accId)) {
            log.error("账号不存在！");
            return false;
        }
        log.info("accId=" + accId + "===============================================");
        Account account = accountService.selectById(Integer.valueOf(accId));
        if (account == null) {
            log.error("账号不存在！");
            return false;
        }
        boolean verify = false;
        try {
            verify = JWTUtil.verify(token);
        } catch (TokenExpiredException e) {
            //过期
            log.error("toke过期");
            httpServletResponse.getWriter().write("dead,fuck to login");
            return false;
        } catch (Exception e) {
            //过期
            log.error("toke错误");
            httpServletResponse.getWriter().write("error");
            return false;
        }
        if (!verify) {
            log.error("toke错误");
            httpServletResponse.getWriter().write(" error,fuck to login");
            return false;
        }
        //刷新过期时间
        redisTemplate.expire(refreshToken, JWTUtil.REFRESH_TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
        return true;
    }

}
