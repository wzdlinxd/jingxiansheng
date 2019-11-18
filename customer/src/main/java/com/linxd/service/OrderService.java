package com.linxd.service;

import com.linxd.bean.vo.order.OrderCreateVo;
import com.linxd.bean.vo.order.OrderQueryVo;
import com.linxd.entity.Order;
import com.linxd.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 21:44
 * Description: No Description
 */
@FeignClient(value = "common", path = "/order")
public interface OrderService {
    @PostMapping("/create")
    boolean create(@RequestBody OrderCreateVo vos);

    @GetMapping("/delete")
    boolean delete(@RequestParam Integer orderId);

    @GetMapping("/list")
    List<Order> getOrderList(@RequestBody OrderQueryVo vo);
}
