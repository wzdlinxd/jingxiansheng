package com.linxd.service.impl;

import com.linxd.bean.vo.ShopQueryVo;
import com.linxd.entity.Shop;
import com.linxd.mapper.ShopDao;
import com.linxd.service.ShopService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.linxd.utils.SolrUtils;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private SolrUtils<Shop> solrUtils;

    public ShopServiceImpl() {}
/*

    @Autowired
    public ShopServiceImpl(SolrUtils<Shop> solrUtils) {
        this.solrUtils = solrUtils;
        solrUtils.setCore("shop");
    }
*/

    @Override
    public List<Shop> selectBySolr(ShopQueryVo vo) {
        solrUtils.setCore("shop");
        List<String> params = new ArrayList<>();
        params.add("shop_name");
        List<Shop> shopList = solrUtils.queryFromSolr(params, vo.getName()
                , Shop.class,vo.getPage(),vo.getSize());
        return shopList;
    }

}
