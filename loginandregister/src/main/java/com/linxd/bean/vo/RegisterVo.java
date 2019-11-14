package com.linxd.bean.vo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotEmpty
    private String account;
    @NotEmpty
    private String password;
    @NotEmpty
    private String comfirm;
    @NotEmpty
    private String name;
    @NotNull
    private Integer role;
}
