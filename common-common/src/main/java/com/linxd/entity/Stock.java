package com.linxd.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Builder;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author linxd
 * @since 2019-11-17
 */
@Builder
@SolrDocument(solrCoreName = "stock")
public class Stock extends Model<Stock> {

    private static final long serialVersionUID = 1L;

    @Field("stock_id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 商品名称
     */
    @Field("goods_name")
    @TableField("goods_name")
    private String goodsName;
    /**
     * 商品价格
     */
    @Field("goods_price")
    @TableField("goods_price")
    private Double goodsPrice;
    /**
     * 商品详情
     */
    @Field("goods_details")
    @TableField("goods_details")
    private String goodsDetails;
    /**
     * 库存数量
     */
    @Field("stock")
    private Integer stock;
    /**
     * 状态 0：下架；1：上架
     */
    @Field("status")
    private Integer status;
    @Field("shop_id")
    @TableField("shop_id")
    private Integer shopId;
    /**
     * 图片
     */
    @Field("image")
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

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
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
