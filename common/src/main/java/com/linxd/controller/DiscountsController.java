package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.linxd.entity.Discounts;
import com.linxd.entity.Result;
import com.linxd.entity.ShopCar;
import com.linxd.service.DiscountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Controller
@RequestMapping("/discounts")
public class DiscountsController {
    @Autowired
    private DiscountsService discountsService;

    /**
     * 获取商店的折扣列表
     * @param shopId
     * @return
     */
    @GetMapping("/list")
    List<Discounts> getDiscountList(@RequestParam Integer shopId) {
        return discountsService.selectList(new EntityWrapper<Discounts>().eq("shop_id", shopId));
    }

    /**
     * 添加折扣
     * @param discount
     * @return
     */
    @PostMapping("/create")
    public boolean create(@RequestBody Discounts discount) {
        return discountsService.insert(discount);
    }

    /**
     * 删除折扣
     * @param discountId
     * @return
     */
    @GetMapping("/delete")
    public boolean delete(@RequestParam Integer discountId) {
        return discountsService.delete(new EntityWrapper<Discounts>().eq("id", discountId));
    }

    /**
     * 计算最终价格
     * @param shopCars
     * @return
     */
    @PostMapping("/realcost")
    public Double getRealCost(@RequestBody List<ShopCar> shopCars) {
        return discountsService.getRealCost(shopCars);
    }
}

