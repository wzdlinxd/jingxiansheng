package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.linxd.bean.entity.Account;
import com.linxd.bean.vo.RegisterVo;
import com.linxd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/selectByAcc")
    public Account selectByAccount(@RequestParam String account, @RequestParam Integer role) {
        return accountService.selectOne(new EntityWrapper<Account>()
                .eq("account", account)
                .eq("role", role));
    }

    @GetMapping("/selectById")
    public Account selectById(@RequestParam Integer accId) {
        return accountService.selectOne(new EntityWrapper<Account>()
                .eq("id", accId));
    }

    @PostMapping("/create")
    public boolean create(@RequestBody RegisterVo vo) {
        return accountService.create(
                Account.builder()
                        .name(vo.getName())
                        .account(vo.getAccount())
                        .password(vo.getPassword())
                        .role(vo.getRole())
                        .build());
    }
}

