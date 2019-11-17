package com.linxd.service;

import com.linxd.bean.vo.shop.ShopCreateVo;
import com.linxd.bean.vo.shop.ShopUpdateVo;
import com.linxd.entity.Result;
import com.linxd.entity.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @GetMapping("/myshops")
    List<Shop> getMyShops(@RequestParam Integer accId);

    @GetMapping("/{id}")
    Shop getShop(@PathVariable(value = "id") Integer id);

    @PostMapping("/create")
    boolean create(@RequestBody ShopCreateVo vo);

    @GetMapping("/delete")
    boolean delete(@RequestParam Integer shopId);

    @GetMapping("/status")
    boolean status(@RequestParam Integer shopId, @RequestParam Integer status);

    @PostMapping("/update")
    boolean update(@RequestBody ShopUpdateVo vo);
}
