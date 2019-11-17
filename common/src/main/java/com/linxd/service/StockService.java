package com.linxd.service;

import com.linxd.bean.vo.stock.StockQueryVo;
import com.linxd.entity.Stock;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linxd
 * @since 2019-11-17
 */
public interface StockService extends IService<Stock> {
    List<Stock> selectBySolr(StockQueryVo vo);
}
