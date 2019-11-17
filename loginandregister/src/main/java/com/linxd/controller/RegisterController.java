package com.linxd.controller;

import com.linxd.bean.vo.account.RegisterVo;
import com.linxd.entity.Account;
import com.linxd.entity.Result;
import com.linxd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/13 16:48
 * Description: No Description
 */
@RestController
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public Result<String> register(@RequestBody @Valid RegisterVo vo, BindingResult result) {
        if (result.hasErrors()) {
            return new Result<String>(400, null, "参数为空");
        }
        //检查重复注册
        Account account = accountService.selectByAccount(vo.getAccount(),vo.getRole());
        if (account != null) {
            return new Result<String>(401, null, "重复注册");
        }
        //检查密码一致
        if (!vo.getComfirm().equals(vo.getPassword())) {
            return new Result<String>(400, null, "密码不一致");
        }
        accountService.create(vo);
        return new Result<String>(200, null, "注册成功");
    }
}
