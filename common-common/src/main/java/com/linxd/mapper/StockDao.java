package com.linxd.mapper;

import com.linxd.entity.Stock;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author linxd
 * @since 2019-11-17
 */
@Mapper
public interface StockDao extends BaseMapper<Stock> {

}
