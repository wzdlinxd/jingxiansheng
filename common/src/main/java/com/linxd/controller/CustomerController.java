package com.linxd.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.linxd.bean.vo.customer.CustomerUpdateVo;
import com.linxd.entity.Customer;
import com.linxd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author linxd
 * @since 2019-11-14
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/update")
    public boolean update(@RequestBody CustomerUpdateVo vo) {
        return customerService.update(
                Customer.builder().address(vo.getAddress())
                        .phone(vo.getPhone())
                        .build()
                , new EntityWrapper<Customer>().eq("id", vo.getId()));

    }
}

