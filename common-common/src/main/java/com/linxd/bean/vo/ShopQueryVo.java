package com.linxd.bean.vo;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/16 1:02
 * Description: No Description
 */
@Data
@Builder
public class ShopQueryVo {
    private String name;
    private int page;
    private int size;

    
}
