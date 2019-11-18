package com.linxd.service;

import com.baomidou.mybatisplus.service.IService;
import com.linxd.bean.vo.order.OrderCreateVo;
import com.linxd.bean.vo.order.OrderQueryVo;
import com.linxd.entity.Order;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
public interface OrderService extends IService<Order> {
    boolean create(OrderCreateVo vo);

    List<Order> getOrderList(@RequestBody OrderQueryVo vo);
}
