package com.linxd.bean.entity;

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
 * @since 2019-11-14
 */
public class Stock extends Model<Stock> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    @TableField("goods_name")
    private String goodsName;
    /**
     * 商品价格
     */
    @TableField("goods_price")
    private String goodsPrice;
    /**
     * 商品详情
     */
    @TableField("goods_details")
    private String goodsDetails;
    /**
     * 库存数量
     */
    private Integer stock;
    /**
     * 状态 0：下架；1：上架
     */
    private Integer status;
    @TableField("shop_id")
    private Integer shopId;
    /**
     * 图片
     */
    private String image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static final String ID = "id";

    public static final String GOODS_NAME = "goods_name";

    public static final String GOODS_PRICE = "goods_price";

    public static final String GOODS_DETAILS = "goods_details";

    public static final String STOCK = "stock";

    public static final String STATUS = "status";

    public static final String SHOP_ID = "shop_id";

    public static final String IMAGE = "image";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Stock{" +
        ", id=" + id +
        ", goodsName=" + goodsName +
        ", goodsPrice=" + goodsPrice +
        ", goodsDetails=" + goodsDetails +
        ", stock=" + stock +
        ", status=" + status +
        ", shopId=" + shopId +
        ", image=" + image +
        "}";
    }
}
