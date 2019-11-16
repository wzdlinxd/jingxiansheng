package com.linxd.controller;

import com.linxd.bean.vo.ShopQueryVo;
import com.linxd.entity.Result;
import com.linxd.entity.Shop;
import com.linxd.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/15 12:50
 * Description: No Description
 */
@Slf4j
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 查询所有商店
     * @param vo
     * @return
     */
    @PostMapping("/list")
    public Result<List<Shop>> getShopList(@RequestBody ShopQueryVo vo) {
        log.info("访问查询所有商店/////////////");
        List<Shop> shopList = shopService.getShopList(vo);
        return new Result<>(200, shopList, "ok");
    }

    /**
     * 获取指定商店信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Shop> getShop(@PathVariable(value = "id") Integer id) {

        Shop shop = shopService.getShop(id);
        return new Result<>(200, shop, "ok");
    }

    /**
     * 通过搜索引擎搜索
     * @param vo
     * @return
     */
    @PostMapping("/solrlist")
    public List<Shop> selectBySolr(@RequestBody ShopQueryVo vo) {
        return shopService.selectBySolr(vo);
    }
}
