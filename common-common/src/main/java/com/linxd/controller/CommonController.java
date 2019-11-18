package com.linxd.controller;

import com.linxd.entity.Result;
import com.linxd.entity.Shop;
import com.linxd.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 2:47
 * Description: No Description
 */
public class CommonController {

    public Integer getAccId(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("token");
        String accId = JWTUtil.getAccount(token);
        return Integer.valueOf(accId);
    }


}
