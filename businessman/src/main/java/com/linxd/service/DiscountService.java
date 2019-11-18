package com.linxd.service;

import com.linxd.entity.Discounts;
import com.linxd.entity.Result;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 16:16
 * Description: No Description
 */
@FeignClient(value = "common", path = "/discounts")
public interface DiscountService {

    @GetMapping("/list")
    List<Discounts> getDiscountList(@RequestParam Integer shopId);

    @PostMapping("/create")
    boolean create(@RequestBody Discounts discount);

    @GetMapping("/delete")
    boolean delete(@RequestParam Integer discountId);
}
