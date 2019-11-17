package com.linxd.bean.vo.shop;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 2:21
 * Description: No Description
 */
@Data
@Builder
public class ShopUpdateVo {
    private Integer id;
    private String shopName;
    private String shopAddress;
    private String shopPhone;
    private String image;
}
