package com.linxd.controller;

import com.linxd.bean.vo.customer.CustomerUpdateVo;
import com.linxd.entity.Result;
import com.linxd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 18:57
 * Description: No Description
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/update")
    public Result<String> update(@RequestBody CustomerUpdateVo vo) {
        customerService.update(vo);
        return new Result<>(200, null, "ok");
    }
}
