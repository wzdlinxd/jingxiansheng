package com.linxd.bean.vo.account;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/13 16:58
 * Description: No Description
 */
@Data
@Builder
public class RegisterVo {
    private String account;
    private String password;
    private String name;
    private String comfirm;
    private int role;
}
