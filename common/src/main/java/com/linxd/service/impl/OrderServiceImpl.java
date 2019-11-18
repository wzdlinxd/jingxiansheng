package com.linxd.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.linxd.bean.vo.order.OrderCreateVo;
import com.linxd.bean.vo.order.OrderQueryVo;
import com.linxd.entity.Customer;
import com.linxd.entity.Details;
import com.linxd.entity.Order;
import com.linxd.entity.ShopCar;
import com.linxd.mapper.OrderDao;
import com.linxd.service.CustomerService;
import com.linxd.service.DetailsService;
import com.linxd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private CustomerService customerService;

    @Override
    public List<Order> getOrderList(OrderQueryVo vo) {
        //查询除customeId
        Customer customer = customerService.selectOne(new EntityWrapper<Customer>()
                .eq("acc_id", vo.getAccId()));

        //查询订单
        Page<Order> orderPage = new Page<>(vo.getPage(), vo.getSize());
        this.selectPage(orderPage, new EntityWrapper<Order>()
                .eq("customer_id", customer.getId())
                .orderBy("id", false));

        return orderPage.getRecords();
    }

    @Override
    public boolean create(OrderCreateVo vo) {
        //添加订单
        Order order = Order.builder().adress(vo.getAddress())
                .customerId(vo.getCustomerId())
                .phone(vo.getPhone())
                .shopId(vo.getShopId())
                .price(vo.getPrice())
                .build();
        this.insert(order);
        //添加订单号
        Integer orderId = order.getId();
        StringBuilder code = new StringBuilder("JINGXIANSHENG");
        code.append(String.format("%04d", orderId + 1));
        this.update(Order.builder()
                        .code(code.toString())
                        .build()
                , new EntityWrapper<Order>().eq("id", orderId));

        //添加订单明细
        for (ShopCar shopCar : vo.getShopCars()) {
            detailsService.insert(Details.builder()
                    .num(shopCar.getNum())
                    .orderId(orderId)
                    .stockId(shopCar.getStockId())
                    .price(shopCar.getPrice())
                    .build());
        }
        return true;
    }
}
