package com.linxd.controller;

import com.linxd.bean.vo.stock.StockQueryVo;
import com.linxd.entity.Result;
import com.linxd.entity.Stock;
import com.linxd.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/16 14:33
 * Description: No Description
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/list")
    public Result<List<Stock>> getStockList(@RequestBody StockQueryVo vo) {
        List<Stock> data = stockService.getStockList(vo);
        return new Result<>(200, data, "ok");
    }

    @GetMapping("/{id}")
    public Result<Stock> getStock(@PathVariable(value = "id") Integer id) {
        Stock data = stockService.getStock(id);
        return new Result<>(200, data, "ok");
    }

    @PostMapping("/solrlist")
    public Result<List<Stock>> selectBySolr(@RequestBody StockQueryVo vo) {
        List<Stock> data = stockService.selectBySolr(vo);
        return new Result<>(200, data, "ok");
    }
}
