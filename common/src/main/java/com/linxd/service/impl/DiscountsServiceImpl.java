package com.linxd.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.linxd.entity.Discounts;
import com.linxd.entity.ShopCar;
import com.linxd.entity.Stock;
import com.linxd.mapper.DiscountsDao;
import com.linxd.mapper.ShopCarDao;
import com.linxd.mapper.StockDao;
import com.linxd.service.DiscountsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.linxd.service.ShopService;
import com.linxd.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Service
public class DiscountsServiceImpl extends ServiceImpl<DiscountsDao, Discounts> implements DiscountsService {

    @Override
    public Double getRealCost(List<ShopCar> shopCars) {
        //计算无折扣价格
        Double cost = 0.0;
        for (ShopCar car : shopCars) {
            cost += car.getPrice();
        }
        List<Discounts> list = this.selectList(new EntityWrapper<Discounts>()
                .eq("shop_id", shopCars.get(0).getShopId())
                .orderBy("full_num", false));

        //查询符合满减的折扣
        Discounts discounts = null;
        for (Discounts dis : list) {
            if (cost > dis.getFullNum()) {
                discounts = dis;
                break;
            }
        }

        if (discounts != null) {
            cost -= discounts.getSubtractNum();
        }

        return cost;
    }
}
