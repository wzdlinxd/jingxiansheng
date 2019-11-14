package com.linxd.Interceptor;

import com.linxd.bean.entity.Account;
import com.linxd.service.AccountService;
import com.linxd.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/14 15:14
 * Description: No Description
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("目标方法执行前执行");
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        String accId = JWTUtil.getAccount(token);
        log.info("accId=" + accId + "===============================================");
        Account account = accountService.selectById(Integer.valueOf(accId));
        if (account == null) {
            log.error("账号不存在！");
            return false;
        }
        boolean verify = JWTUtil.verify(token);
        if (!verify) {
            log.error("toke错误");
            return false;
        }
        return true;
    }

}
