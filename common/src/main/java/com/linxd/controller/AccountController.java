package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.linxd.bean.vo.account.AccountUpdateVo;
import com.linxd.bean.vo.account.RegisterVo;
import com.linxd.entity.Account;
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

    /**
     * 通过账号、权限查账号信息
     * @param account
     * @param role
     * @return
     */
    @GetMapping("/selectByAcc")
    public Account selectByAccount(@RequestParam String account, @RequestParam Integer role) {
        return accountService.selectOne(new EntityWrapper<Account>()
                .eq("account", account)
                .eq("role", role));
    }

    /**
     * 通过主键查
     * @param accId
     * @return
     */
    @GetMapping("/selectById")
    public Account selectById(@RequestParam Integer accId) {
        return accountService.selectOne(new EntityWrapper<Account>()
                .eq("id", accId));
    }

    /**
     * 添加账号
     * @param vo
     * @return
     */
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

    /**
     * 修改
     * @param vo
     * @return
     */
    @PostMapping("/update")
    public boolean updata(@RequestBody AccountUpdateVo vo) {
        return accountService.update(Account.builder().name(vo.getName()).password(vo.getPassword()).build()
                , new EntityWrapper<Account>().eq("id", vo.getAccId()));
    }

}

