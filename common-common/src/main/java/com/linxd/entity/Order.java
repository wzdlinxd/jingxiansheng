package com.linxd.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author linxd
 * @since 2019-11-13
 */
@Builder
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 订单号
     */
    private String code;
    /**
     * 客户id
     */
    @TableField("customer_id")
    private Integer customerId;
    /**
     * 收货地址
     */
    private String adress;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 电话
     */
    private String phone;

    /**
     * 客户id
     */
    @TableField("shop_id")
    private Integer shopId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static final String ID = "id";

    public static final String CODE = "code";

    public static final String CUSTOMER_ID = "customer_id";

    public static final String ADRESS = "adress";

    public static final String CREATE_TIME = "create_time";

    public static final String PHONE = "phone";

    public static final String SHOPID = "shop_id";

    public static final String PRICE = "price";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Order{" +
        ", id=" + id +
        ", code=" + code +
        ", customerId=" + customerId +
        ", adress=" + adress +
        ", createTime=" + createTime +
        "}";
    }
}
