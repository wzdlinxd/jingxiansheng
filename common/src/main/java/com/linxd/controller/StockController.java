package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.linxd.bean.vo.stock.StockCreateVo;
import com.linxd.bean.vo.stock.StockQueryVo;
import com.linxd.bean.vo.stock.StockUpdateVo;
import com.linxd.entity.Stock;
import com.linxd.service.StockService;
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
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping("/list")
    public List<Stock> getStockList(@RequestBody StockQueryVo vo) {
        Page<Stock> stockPage = new Page<>(vo.getPage(), vo.getSize());
        Page<Stock> selectPage = stockService.selectPage(stockPage
                , new EntityWrapper<Stock>().eq("shop_id", vo.getShopId())
                                            .eq(vo.getStatus() != null,"status", vo.getStatus()));
        return selectPage.getRecords();
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable(value = "id") Integer id) {
        return stockService.selectOne(new EntityWrapper<Stock>()
                .eq("id", id));
    }

    @PostMapping("/solrlist")
    public List<Stock> selectBySolr(@RequestBody StockQueryVo vo) {
        return stockService.selectBySolr(vo);
    }

   /* @PostMapping("/mystock")
    public List<Stock> getShopStock(@RequestBody StockQueryVo vo) {
        Page<Stock> stockPage = new Page<>(vo.getPage(), vo.getSize());
        Page<Stock> selectPage = stockService.selectPage(stockPage
                , new EntityWrapper<Stock>().eq("shop_id", vo.getShopId()));
        return selectPage.getRecords();
    }*/

    @PostMapping("/create")
    public boolean create(@RequestBody StockCreateVo vo) {
        return stockService.insert(
                Stock.builder().goodsName(vo.getGoodsName())
                        .goodsDetails(vo.getGoodsDetails())
                        .shopId(vo.getShopId())
                        .goodsPrice(vo.getGoodsPrice())
                        .stock(vo.getStock())
                        .image(vo.getImage())
                        .build());
    }

    @GetMapping("/delete")
    public boolean delete(@RequestParam Integer stockId) {
        return stockService.delete(new EntityWrapper<Stock>().eq("id", stockId));
    }

    @GetMapping("/status")
    public boolean status(@RequestParam Integer stockId, @RequestParam Integer status) {
        return stockService.update(Stock.builder().status(status).build()
                , new EntityWrapper<Stock>().eq("id", stockId));
    }

    @PostMapping("/update")
    public boolean update(@RequestBody StockUpdateVo vo) {
        return stockService.update(
                Stock.builder().goodsName(vo.getGoodsName())
                        .goodsDetails(vo.getGoodsDetails())
                        .goodsPrice(vo.getGoodsPrice())
                        .stock(vo.getStock())
                        .image(vo.getImage())
                        .build()
                , new EntityWrapper<Stock>().eq("id", vo.getId()));
    }
}

