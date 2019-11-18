package com.linxd.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Builder;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Builder
public class Details extends Model<Details> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品id
     */
    @TableField("stock_id")
    private Integer stockId;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 订单id
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 价格
     */
    @TableField("price")
    private Double price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static final String ID = "id";

    public static final String STOCK_ID = "stock_id";

    public static final String NUM = "num";

    public static final String ORDER_ID = "order_id";

    public static final String PRICE = "price";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Details{" +
        ", id=" + id +
        ", stockId=" + stockId +
        ", num=" + num +
        ", orderId=" + orderId +
        "}";
    }
}
