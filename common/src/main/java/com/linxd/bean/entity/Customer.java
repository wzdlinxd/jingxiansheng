package com.linxd.bean.entity;

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
 * @since 2019-11-14
 */
@Builder
public class Customer extends Model<Customer> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 电话
     */
    private String phone;
    /**
     * 账号id
     */
    @TableField("acc_id")
    private Integer accId;
    /**
     * 默认地址
     */
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static final String ID = "id";

    public static final String PHONE = "phone";

    public static final String ACC_ID = "acc_id";

    public static final String ADDRESS = "address";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Customer{" +
        ", id=" + id +
        ", phone=" + phone +
        ", accId=" + accId +
        ", address=" + address +
        "}";
    }
}
