package com.linxd.controller;

import com.linxd.bean.vo.stock.StockCreateVo;
import com.linxd.bean.vo.stock.StockQueryVo;
import com.linxd.bean.vo.stock.StockUpdateVo;
import com.linxd.entity.Result;
import com.linxd.entity.Stock;
import com.linxd.service.StockService;
import com.linxd.utils.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 15:17
 * Description: No Description
 */
@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    /**
     * 查询某店铺的商品
     * @param vo
     * @return
     */
    @PostMapping("/mystock")
    public Result<List<Stock>> getShopStock(@RequestBody StockQueryVo vo) {
        List<Stock> data = stockService.getStockList(vo);
        return new Result<>(200, data, "ok");
    }

    /**
     * 查看某个商品
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Stock> getStock(@PathVariable(value = "id") Integer id) {
        Stock data = stockService.getStock(id);
        return new Result<>(200, data, "ok");
    }

    /**
     * 添加商品
     * @param vo
     * @param file
     * @return
     */
    @PostMapping("/create")
    public Result<String> create(@RequestBody StockCreateVo vo, @RequestBody MultipartFile file) {
        //文件上传。。。
        //。。。。。
        if (file != null) {
            String image = UploadUtil.upload(file);
            vo.setImage(image);
        } else {
            vo.setImage("default.jpg");
        }
        stockService.create(vo);
        return new Result<>(200, null, "ok");
    }

    /**
     * 删除
     * @param stockId
     * @return
     */
    @GetMapping("/delete")
    public Result<String> delete(@RequestParam Integer stockId) {
        stockService.delete(stockId);
        return new Result<>(200, null, "ok");
    }

    /**
     * 修改商品状态
     * @param stockId
     * @param status
     * @return
     */
    @GetMapping("/status")
    public Result<String> status(@RequestParam Integer stockId, @RequestParam Integer status) {
        stockService.status(stockId, status);
        return new Result<>(200, null, "ok");
    }

    /**
     * 修改商品信息
     * @param vo
     * @return
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody StockUpdateVo vo, @RequestBody MultipartFile file) {
        //上传文件。。。。。。
        //。。。。。
        if (file != null) {
            String image = UploadUtil.upload(file);
            vo.setImage(image);
        } else {
            vo.setImage("default.jpg");
        }
        stockService.update(vo);
        return new Result<>(200, null, "ok");
    }
}
