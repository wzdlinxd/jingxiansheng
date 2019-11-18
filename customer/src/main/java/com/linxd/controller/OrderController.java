package com.linxd.controller;

import com.linxd.bean.vo.order.OrderCreateVo;
import com.linxd.bean.vo.order.OrderQueryVo;
import com.linxd.entity.Order;
import com.linxd.entity.Result;
import com.linxd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 21:41
 * Description: No Description
 */
@RestController
@RequestMapping("/order")
public class OrderController extends CommonController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param vo
     * @return
     */
    @PostMapping("/create")
    public Result<String> create(@RequestBody OrderCreateVo vo) {
        orderService.create(vo);
        return new Result<>(200, null, "ok");
    }

    @GetMapping("/delete")
    public Result<String> delete(@RequestParam Integer orderId) {
        orderService.delete(orderId);
        return new Result<>(200, null, "ok");
    }

    @GetMapping("/list")
    public Result<List<Order>> getOrderList(@RequestBody OrderQueryVo vo, HttpServletRequest request) {
        Integer accId = this.getAccId(request);
        vo.setAccId(accId);
        List<Order> data = orderService.getOrderList(vo);
        return new Result<>(200, data, "ok");
    }


}
