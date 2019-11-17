package com.linxd.service;

import com.linxd.bean.vo.shop.ShopQueryVo;
import com.linxd.entity.Shop;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linxd
 * @since 2019-11-14
 */
public interface ShopService extends IService<Shop> {
    List<Shop> selectBySolr(ShopQueryVo vo);
}
