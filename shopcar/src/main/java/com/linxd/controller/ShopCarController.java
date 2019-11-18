package com.linxd.controller;

import com.linxd.bean.vo.shopcar.ShopCarCreateVo;
import com.linxd.entity.Result;
import com.linxd.entity.ShopCar;
import com.linxd.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 20:25
 * Description: No Description
 */
@RestController
@RequestMapping("/shopCar")
public class ShopCarController extends CommonController {
    @Autowired
    private ShopCarService shopCarService;

    /**
     * 添加购物车
     * @param vo
     * @param request
     * @return
     */
    @PostMapping("/create")
    public Result<String> create(@RequestBody ShopCarCreateVo vo, HttpServletRequest request) {
        Integer accId = this.getAccId(request);
        vo.setAccId(accId);
        ShopCar shopCar = shopCarService.getShopCar(vo.getStockId(), accId);
        if (shopCar != null) {
            //存在则在数量
            shopCarService.updateNum(shopCar.getId(), shopCar.getNum() + vo.getNum());
        } else {
            //不存在就新建
            shopCarService.create(vo);
        }

        return new Result<>(200, null, "ok");
    }

    /**
     * 查询某个客户在某个店的购物车列表
     * @param shopId
     * @param request
     * @return
     */
    @PostMapping("list")
    public Result<List<ShopCar>> getShopCarList(@RequestParam Integer shopId
            , HttpServletRequest request) {
        Integer accId = this.getAccId(request);
        List<ShopCar> data = shopCarService.getShopCarList(shopId, accId);
        return new Result<>(200, data, "ok");
    }


    /**
     * 减少购物车项的数量
     * @param shopCarId
     * @param num
     * @return
     */
    @PostMapping("subtractnum")
    public Result<String> updateNum(@RequestParam Integer shopCarId, @RequestParam Integer num) {
        ShopCar shopCar = shopCarService.getShopCarById(shopCarId);
        shopCarService.updateNum(shopCarId, shopCar.getNum() - num);
        return new Result<>(200, null, "ok");
    }


}
