package com.linxd.controller;

import com.linxd.entity.Discounts;
import com.linxd.entity.Result;
import com.linxd.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 16:13
 * Description: No Description
 */
@RestController
@RequestMapping("/discounts")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    /**
     * 获取商店的折扣列表
     * @param shopId
     * @return
     */
    @GetMapping("/list")
    public Result<List<Discounts>> getDiscountList(@RequestParam Integer shopId) {
        List<Discounts> data = discountService.getDiscountList(shopId);
        return new Result<>(200, data, "ok");
    }

    /**
     * 添加折扣
     * @param discount
     * @return
     */
    @PostMapping("/create")
    public Result<String> create(@RequestBody Discounts discount) {
        discountService.create(discount);
        return new Result<>(200, null, "ok");
    }

    /**
     * 删除折扣
     * @param discountId
     * @return
     */
    @GetMapping("/delete")
    public Result<String> delete(@RequestParam Integer discountId) {
        discountService.delete(discountId);
        return new Result<>(200, null, "ok");
    }

}
