package com.linxd.bean.vo.account;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 17:08
 * Description: No Description
 */
@Data
@Builder
public class AccountUpdateVo {
    private Integer accId;
    private String name;
    private String password;
    private String comfirm;
}
