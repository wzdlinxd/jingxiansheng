package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.linxd.bean.vo.order.OrderCreateVo;
import com.linxd.bean.vo.order.OrderQueryVo;
import com.linxd.entity.Details;
import com.linxd.entity.Order;
import com.linxd.entity.ShopCar;
import com.linxd.service.DetailsService;
import com.linxd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public boolean create(@RequestBody OrderCreateVo vo) {
        return orderService.create(vo);
    }

    @GetMapping("/delete")
    public boolean delete(@RequestParam Integer orderId) {
        return orderService.delete(new EntityWrapper<Order>().eq("id", orderId));
    }

    @GetMapping("/list")
    public List<Order> getOrderList(@RequestBody OrderQueryVo vo) {
        return orderService.getOrderList(vo);
    }


    @PostMapping("/shoporder")
    public List<Order> getShopOrderList(@RequestParam OrderQueryVo vo) {
        //查询订单
        Page<Order> orderPage = new Page<>(vo.getPage(), vo.getSize());
        orderService.selectPage(orderPage, new EntityWrapper<Order>()
                .eq("shop_id", vo.getShopId())
                .orderBy("id", false));

        return orderPage.getRecords();
    }
}

