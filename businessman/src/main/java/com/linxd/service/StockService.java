package com.linxd.service;

import com.linxd.bean.vo.shop.ShopUpdateVo;
import com.linxd.bean.vo.stock.StockCreateVo;
import com.linxd.bean.vo.stock.StockQueryVo;
import com.linxd.bean.vo.stock.StockUpdateVo;
import com.linxd.entity.Result;
import com.linxd.entity.Shop;
import com.linxd.entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 15:16
 * Description: No Description
 */
@FeignClient(value = "common", path = "/stock")
public interface StockService {
    @PostMapping("/list")
    List<Stock> getStockList(@RequestBody StockQueryVo vo);

    @GetMapping("/{id}")
    Stock getStock(@PathVariable(value = "id") Integer id);

    @PostMapping("/create")
    boolean create(@RequestBody StockCreateVo vo);

    @GetMapping("/delete")
    boolean delete(@RequestParam Integer stockId);

    @GetMapping("/status")
    boolean status(@RequestParam Integer stockId, @RequestParam Integer status);

    @PostMapping("/update")
    boolean update(@RequestBody StockUpdateVo vo);
}
