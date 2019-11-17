package com.linxd.controller;

import com.linxd.bean.vo.account.AccountUpdateVo;
import com.linxd.entity.Result;
import com.linxd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 16:20
 * Description: No Description
 */
@RestController
@RequestMapping("/account")
public class AccountController extends CommonController {
    @Autowired
    private AccountService accountService;

    /**
     * 修改账号名
     * @param vo
     * @return
     */
    @PostMapping("/updateName")
    public Result<String> updataName(@RequestBody AccountUpdateVo vo, HttpServletRequest request) {
        Integer accId = this.getAccId(request);
        vo.setAccId(accId);
        accountService.updata(vo);
        return new Result<>(200, null, "ok");

    }

    /**
     * 修改密码
     * @param vo
     * @param request
     * @return
     */
    @PostMapping("/updataPass")
    public Result<String> updataPass(@RequestBody AccountUpdateVo vo, HttpServletRequest request) {
        if (!vo.getComfirm().equals(vo.getPassword())) {
            return new Result<>(400, null, "密码不一致");
        }
        Integer accId = this.getAccId(request);
        vo.setAccId(accId);
        accountService.updata(vo);
        return new Result<>(200, null, "ok");

    }
}
