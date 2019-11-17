package com.linxd.service;

import com.linxd.bean.vo.stock.StockQueryVo;
import com.linxd.entity.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/16 14:34
 * Description: No Description
 */
@FeignClient(value = "common", path = "/stock")
public interface StockService {
    @PostMapping("/list")
    List<Stock> getStockList(@RequestBody StockQueryVo vo);

    @GetMapping("/{id}")
    Stock getStock(@PathVariable(value = "id") Integer id);

    @PostMapping("/solrlist")
    List<Stock> selectBySolr(@RequestBody StockQueryVo vo);
}
