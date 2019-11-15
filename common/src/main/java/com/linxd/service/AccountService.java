package com.linxd.service;

import com.baomidou.mybatisplus.service.IService;
import com.linxd.entity.Account;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
public interface AccountService extends IService<Account> {
    boolean create(Account account);
}
