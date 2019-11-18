package com.linxd.service;

import com.linxd.bean.vo.shopcar.ShopCarCreateVo;
import com.linxd.entity.Result;
import com.linxd.entity.ShopCar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 20:45
 * Description: No Description
 */
@FeignClient(value = "common",path = "/shopCar")
public interface ShopCarService {
    @PostMapping("/create")
    boolean create(@RequestBody ShopCarCreateVo vo);

    @PostMapping("list")
    List<ShopCar> getShopCarList(@RequestParam Integer shopId, @RequestParam Integer accId);

    @PostMapping("shopcar")
    ShopCar getShopCar(@RequestParam Integer stockId, @RequestParam Integer accId);

    /**
     * 修改购物车项的数量
     * @param shopCarId
     * @param num
     * @return
     */
    @PostMapping("updatenum")
    boolean updateNum(@RequestParam Integer shopCarId, @RequestParam Integer num);

    @GetMapping("{id}")
    ShopCar getShopCarById(@PathVariable Integer id);
}
