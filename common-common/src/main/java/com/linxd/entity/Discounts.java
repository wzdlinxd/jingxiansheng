package com.linxd.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
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
public class Discounts extends Model<Discounts> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 优惠门槛价
     */
    @TableField("full_num")
    private Integer fullNum;
    /**
     * 优惠多少
     */
    @TableField("subtract_num")
    private Integer subtractNum;
    /**
     * 店id
     */
    @TableField("shop_id")
    private Integer shopId;
    /**
     * 是否会员才能享受 0：否；1：是
     */
    private Integer vip;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFullNum() {
        return fullNum;
    }

    public void setFullNum(Integer fullNum) {
        this.fullNum = fullNum;
    }

    public Integer getSubtractNum() {
        return subtractNum;
    }

    public void setSubtractNum(Integer subtractNum) {
        this.subtractNum = subtractNum;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public static final String ID = "id";

    public static final String FULL_NUM = "full_num";

    public static final String SUBTRACT_NUM = "subtract_num";

    public static final String SHOP_ID = "shop_id";

    public static final String VIP = "vip";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Discounts{" +
        ", id=" + id +
        ", fullNum=" + fullNum +
        ", subtractNum=" + subtractNum +
        ", shopId=" + shopId +
        ", vip=" + vip +
        "}";
    }
}
