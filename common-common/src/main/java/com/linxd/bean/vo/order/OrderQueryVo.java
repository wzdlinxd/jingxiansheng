package com.linxd.bean.vo.order;

import lombok.Builder;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/18 2:32
 * Description: No Description
 */
@Builder
@Data
public class OrderQueryVo {
    private Integer accId;
    private Integer shopId;
    private Integer page;
    private Integer size;
}
