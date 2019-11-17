package com.linxd.bean.vo.stock;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 16:06
 * Description: No Description
 */
@Data
@Builder
public class StockUpdateVo {
    private Integer id;
    private String goodsName;
    private Integer goodsPrice;
    private String goodsDetails;
    private Integer stock;
    private String image;
}
