package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.linxd.bean.vo.ShopQueryVo;
import com.linxd.entity.Result;
import com.linxd.entity.Shop;
import com.linxd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linxd
 * @since 2019-11-14
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 分页获得全部商店
     * @param vo
     * @return
     */
    @PostMapping("/list")
    public List<Shop> getShopList(@RequestBody ShopQueryVo vo) {
        Page<Shop> shopPage = new Page<>(vo.getPage(), vo.getSize());
        Page<Shop> selectPage = shopService.selectPage(shopPage);
        return selectPage.getRecords();
    }

    /**
     * 根据主键查
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Shop getShop(@PathVariable(value = "id") Integer id) {
        return shopService.selectOne(new EntityWrapper<Shop>()
            .eq("id", id));

    }

    @PostMapping("/solrlist")
    public List<Shop> selectBySolr(@RequestBody ShopQueryVo vo) {
        return shopService.selectBySolr(vo);
    }
}

