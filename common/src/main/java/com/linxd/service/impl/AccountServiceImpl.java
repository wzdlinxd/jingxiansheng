package com.linxd.service.impl;

import com.linxd.bean.entity.Account;
import com.linxd.bean.entity.Customer;
import com.linxd.mapper.AccountDao;
import com.linxd.service.AccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.linxd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {
    @Autowired
    private CustomerService customerService;

    @Override
    public boolean create(Account account) {
        boolean result = this.insert(account);
        //
        if (account.getRole() == 2) {
            result = result && customerService.insert(
                    Customer.builder()
                            .phone(account.getAccount())
                            .accId(account.getId())
                            .build());
        }
        return true;
    }
}
