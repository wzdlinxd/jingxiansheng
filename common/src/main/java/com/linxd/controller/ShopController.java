package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.linxd.bean.vo.shop.ShopCreateVo;
import com.linxd.bean.vo.shop.ShopQueryVo;
import com.linxd.bean.vo.shop.ShopUpdateVo;
import com.linxd.entity.Shop;
import com.linxd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 通过搜索引擎搜索
     * @param vo
     * @return
     */
    @PostMapping("/solrlist")
    public List<Shop> selectBySolr(@RequestBody ShopQueryVo vo) {
        return shopService.selectBySolr(vo);
    }

    /**
     * 某个商家的店铺列表
     * @param accId
     * @return
     */
    @GetMapping("/myshops")
    public List<Shop> getMyShops(@RequestParam Integer accId) {
        return shopService.selectList(new EntityWrapper<Shop>()
                .eq("accId", accId));
    }

    /**
     * 新建商店
     * @param vo
     * @return
     */
    @PostMapping("/create")
    public boolean create(@RequestBody ShopCreateVo vo) {
        return shopService.insert(
                Shop.builder().image(vo.getImage())
                        .shopName(vo.getShopName())
                        .shopAddress(vo.getShopAddress())
                        .shopPhone(vo.getShopPhone())
                        .accId(vo.getAccId())
                        .build());
    }

    /**
     * 删除店铺
     * @param shopId
     * @return
     */
    @GetMapping("/delete")
    public boolean delete(@RequestParam Integer shopId) {
        return shopService.delete(new EntityWrapper<Shop>().eq("id", shopId));
    }

    /**
     * 修改营业状态
     * @param shopId
     * @param status
     * @return
     */
    @GetMapping("/status")
    public boolean status(@RequestParam Integer shopId, @RequestParam Integer status) {
        return shopService.update(Shop.builder().status(status).build()
                , new EntityWrapper<Shop>().eq("id", shopId));
    }

    /**
     * 修改店铺信息
     * @param vo
     * @return
     */
    @PostMapping("/update")
    public boolean update(@RequestBody ShopUpdateVo vo) {
        return shopService.update(
                Shop.builder().shopName(vo.getShopName())
                        .shopAddress(vo.getShopAddress())
                        .shopAddress(vo.getShopPhone())
                        .image(vo.getImage())
                        .build()
                , new EntityWrapper<Shop>().eq("id", vo.getId()));
    }
}

