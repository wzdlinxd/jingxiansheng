package com.linxd.bean.vo.shopcar;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 20:56
 * Description: No Description
 */
@Data
@Builder
public class ShopCarCreateVo {
    private Integer stockId;
    private Integer accId;
    private Integer num;
}
