package com.linxd.controller;

import com.linxd.bean.vo.order.OrderQueryVo;
import com.linxd.entity.Order;
import com.linxd.entity.Result;
import com.linxd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 13:13
 * Description: No Description
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/list")
    public Result<List<Order>> getOrderList(@RequestParam OrderQueryVo vo) {
        List<Order> orderList = orderService.getOrderList(vo);
        return new Result<>(200, orderList, "ok");
    }
}
