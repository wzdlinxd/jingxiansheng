package com.linxd.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author linxd
 * @since 2019-11-14
 */
@SolrDocument(solrCoreName = "shop")
public class Shop extends Model<Shop> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @Field("shop_id")
    private Integer id;
    /**
     * 店名
     */
    @Field("shop_name")
    @TableField("shop_name")
    private String shopName;
    /**
     * 店地址
     */
    @Field("shop_address")
    @TableField("shop_address")
    private String shopAddress;
    /**
     * 店电话
     */
    @Field("shop_phone")
    @TableField("shop_phone")
    private String shopPhone;
    /**
     * 商家账号
     */
    @Field("acc_id")
    @TableField("acc_id")
    private Integer accId;

    @Field("image")
    private String image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPhone() {
        return shopPhone;
    }

    public void setShopPhone(String shopPhone) {
        this.shopPhone = shopPhone;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static final String ID = "id";

    public static final String SHOP_NAME = "shop_name";

    public static final String SHOP_ADDRESS = "shop_address";

    public static final String SHOP_PHONE = "shop_phone";

    public static final String ACC_ID = "acc_id";

    public static final String IMAGE = "image";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Shop{" +
        ", id=" + id +
        ", shopName=" + shopName +
        ", shopAddress=" + shopAddress +
        ", shopPhone=" + shopPhone +
        ", accId=" + accId +
        ", image=" + image +
        "}";
    }
}
