package com.linxd.service;

import com.linxd.bean.vo.customer.CustomerUpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.PrivateKey;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 19:01
 * Description: No Description
 */
@FeignClient(value = "common",path = "/account")
public interface CustomerService {
    @RequestMapping("/update")
    boolean update(@RequestBody CustomerUpdateVo vo);
}
