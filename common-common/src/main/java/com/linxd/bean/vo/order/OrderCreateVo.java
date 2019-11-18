package com.linxd.bean.vo.order;

import com.linxd.entity.ShopCar;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/17 23:23
 * Description: No Description
 */
@Data
@Builder
public class OrderCreateVo {
    private List<ShopCar> shopCars;
    private Double price;
    private Integer shopId;
    private Integer customerId;
    private String phone;
    private String address;
}
