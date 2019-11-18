package com.linxd.service;

import com.linxd.bean.vo.order.OrderQueryVo;
import com.linxd.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 13:27
 * Description: No Description
 */
@FeignClient(value = "common",path = "/order")
public interface OrderService {
    @PostMapping("/shoporder")
    List<Order> getOrderList(@RequestParam OrderQueryVo vo);
}
