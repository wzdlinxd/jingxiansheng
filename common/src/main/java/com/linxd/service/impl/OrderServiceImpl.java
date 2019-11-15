package com.linxd.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.linxd.entity.Order;
import com.linxd.mapper.OrderDao;
import com.linxd.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}
