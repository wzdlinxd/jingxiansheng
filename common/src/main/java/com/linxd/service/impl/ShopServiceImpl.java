package com.linxd.service.impl;

import com.linxd.bean.vo.shop.ShopQueryVo;
import com.linxd.entity.Shop;
import com.linxd.mapper.ShopDao;
import com.linxd.service.ShopService;
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
public class ShopServiceImpl extends ServiceImpl<ShopDao, Shop> implements ShopService {

    private SolrUtils<Shop> solrUtils;

    public ShopServiceImpl() {}

    @Autowired
    public ShopServiceImpl(SolrUtils<Shop> solrUtils) {
        this.solrUtils = solrUtils;
        solrUtils.setCore("shop");
    }

    @Override
    public List<Shop> selectBySolr(ShopQueryVo vo) {
        Map<String,Object> params = new HashMap<>();
        params.put("shop_name", vo.getName());
        List<Shop> shopList = solrUtils.queryFromSolr(params, Shop.class
                ,vo.getPage(), vo.getSize());
        return shopList;
    }

}
