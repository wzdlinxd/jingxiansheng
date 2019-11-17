package com.linxd.service;

import com.linxd.bean.vo.shop.ShopQueryVo;
import com.linxd.entity.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/15 12:52
 * Description: No Description
 */
@FeignClient(value = "common", path = "/shop")
public interface ShopService {
    @PostMapping("/list")
    List<Shop> getShopList(@RequestBody ShopQueryVo vo);

    @GetMapping("/{id}")
    Shop getShop(@PathVariable(value = "id") Integer id);

    @PostMapping("/solrlist")
    List<Shop> selectBySolr(@RequestBody ShopQueryVo vo);
}
