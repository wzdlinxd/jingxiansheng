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
public class StockQueryVo {
    private Integer shopId;
    private String name;
    private Integer status;
    private String image;
    private Integer page;
    private Integer size;
}
