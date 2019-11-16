package com.linxd.bean.vo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/14 10:38
 * Description: No Description
 */
@Data
public class LoginVo {
    private String account;
    private String password;
    private Integer role;
}
