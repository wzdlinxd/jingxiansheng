package com.linxd.service;

import com.baomidou.mybatisplus.service.IService;
import com.linxd.bean.entity.Account;
import com.linxd.bean.vo.RegisterVo;
import org.springframework.web.bind.annotation.RequestBody;

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
