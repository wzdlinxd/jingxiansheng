package com.linxd.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@TableName("vip_cost")
public class VipCost extends Model<VipCost> {

    private static final long serialVersionUID = 1L;

    /**
     * 店id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 消费满多少是vip
     */
    private Integer cost;
    @TableField("shop_id")
    private Integer shopId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public static final String ID = "id";

    public static final String COST = "cost";

    public static final String SHOP_ID = "shop_id";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "VipCost{" +
        ", id=" + id +
        ", cost=" + cost +
        ", shopId=" + shopId +
        "}";
    }
}
