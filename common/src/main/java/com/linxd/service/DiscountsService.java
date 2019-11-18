package com.linxd.service;

import com.baomidou.mybatisplus.service.IService;
import com.linxd.entity.Discounts;
import com.linxd.entity.ShopCar;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
public interface DiscountsService extends IService<Discounts> {

    Double getRealCost(List<ShopCar> shopCars);
}
