package com.linxd.bean.vo.stock;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/16 14:42
 * Description: No Description
 */
@Data
@Builder
public class StockCreateVo {
    private Integer shopId;
    private String goodsName;
    private Integer goodsPrice;
    private String goodsDetails;
    private Integer stock;
    private String image;
}
