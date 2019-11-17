package com.linxd.service.impl;

import com.linxd.bean.vo.stock.StockQueryVo;
import com.linxd.entity.Stock;
import com.linxd.mapper.StockDao;
import com.linxd.service.StockService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.linxd.utils.SolrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private SolrUtils<Stock> solrUtils;

    public StockServiceImpl() {}

    @Autowired
    public StockServiceImpl(SolrUtils<Stock> solrUtils) {
        this.solrUtils = solrUtils;
        solrUtils.setCore("stock");
    }

    @Override
    public List<Stock> selectBySolr(StockQueryVo vo) {
        Map<String,Object> params = new HashMap<>();
        params.put("goods_name", vo.getName());
        params.put("goods_details", vo.getName());
        params.put("status", vo.getStatus());
        List<Stock> stockList = solrUtils.queryFromSolr(params, Stock.class,vo.getPage(),vo.getSize());
        return stockList;
    }
}
