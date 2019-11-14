package com.linxd.service.impl;

import com.linxd.entity.Stock;
import com.linxd.mapper.StockDao;
import com.linxd.service.StockService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linxd
 * @since 2019-11-14
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockDao, Stock> implements StockService {

}
