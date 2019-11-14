package com.linxd.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.linxd.bean.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {

}
