package com.linxd.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.linxd.bean.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author linxd
 * @since 2019-11-14
 */
@Mapper
public interface CustomerDao extends BaseMapper<Customer> {

}
