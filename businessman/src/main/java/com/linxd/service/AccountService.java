package com.linxd.service;

import com.linxd.bean.vo.account.AccountUpdateVo;
import com.linxd.entity.Account;
import com.linxd.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/13 15:32
 * Description: No Description
 */
@FeignClient(value = "common",path = "/account")
public interface AccountService {
    /**
     * 根据账号查询账号信息
     * @param account
     * @param role
     * @return
     */
    @GetMapping("/selectByAcc")
    Account selectByAccount(@RequestParam String account, @RequestParam Integer role);

    /**
     * 根据id查询
     * @param accId
     * @return
     */
    @GetMapping("/selectById")
    Account selectById(@RequestParam Integer accId);


    /**
     * 修改
     * @param vo
     * @return
     */
    @PostMapping("/updata")
    boolean updata(@RequestBody AccountUpdateVo vo);
}
