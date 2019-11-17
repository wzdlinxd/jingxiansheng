package com.linxd.bean.vo.customer;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 20:39
 * Description: No Description
 */
@Data
@Builder
public class CustomerUpdateVo {
    private Integer id;
    private String phone;
    private String address;
}
