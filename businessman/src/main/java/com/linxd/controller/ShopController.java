package com.linxd.controller;

import com.linxd.bean.vo.shop.ShopCreateVo;
import com.linxd.bean.vo.shop.ShopUpdateVo;
import com.linxd.entity.Result;
import com.linxd.entity.Shop;
import com.linxd.service.ShopService;
import com.linxd.utils.JWTUtil;
import com.linxd.utils.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ShopController extends CommonController {
    @Autowired
    private ShopService shopService;

    /**
     * 查询自己的商店
     * @return
     */
    @PostMapping("/myshops")
    public Result<List<Shop>> getMyShops(HttpServletRequest httpServletRequest) {
        log.info("访问查询所有商店/////////////");
        Integer accId = this.getAccId(httpServletRequest);
        List<Shop> shopList = shopService.getMyShops(accId);
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
     * 添加商店
     * @param vo
     * @param file
     * @return
     */
    @PostMapping("/create")
    public Result<String> create(@RequestBody ShopCreateVo vo, @RequestBody MultipartFile file, HttpServletRequest httpServletRequest) {
        Integer accId = this.getAccId(httpServletRequest);
        vo.setAccId(accId);
        //文件上传操作
        //。。。。。。。
        if (file != null) {
            String image = UploadUtil.upload(file);
            vo.setImage(image);
        } else {
            vo.setImage("default.jpg");
        }
        shopService.create(vo);
        return new Result<>(200, null, "ok");
   }

    /**
     * 删除
     * @param shopId
     * @return
     */
    @GetMapping("/delete")
    public Result<String> delete(@RequestParam Integer shopId) {
        shopService.delete(shopId);
        return new Result<>(200, null, "ok");
    }

    /**
     * 修改营业状态
     * @param shopId
     * @param status
     * @return
     */
    @GetMapping("/status")
    public Result<String> status(@RequestParam Integer shopId, @RequestParam Integer status) {
        shopService.status(shopId, status);
        return new Result<>(200, null, "ok");
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody ShopUpdateVo vo, @RequestBody MultipartFile file) {
        //文件上传操作
        //。。。。。。。
        if (file != null) {
            String image = UploadUtil.upload(file);
            vo.setImage(image);
        } else {
            vo.setImage("default.jpg");
        }
        shopService.update(vo);
        return new Result<>(200, null, "ok");
    }
}
