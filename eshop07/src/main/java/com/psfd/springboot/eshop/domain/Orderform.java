package com.psfd.springboot.eshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public class Orderform implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_form_id", type = IdType.AUTO)
    private Integer orderFormId;        //订单编号


    @TableField("user_id")
    private User user;          //用户信息

    private String orderFromNo; //订单序号

    private Date submitTime;    //订单提交时间

    private Date consignmentTime;   //发货时间

    private Double totalPrice;      //总金额

    private String remark;      //买家备注

    private String ipaddress;   //买家Ip地址

    private Integer isPayoff;   //买家是否发货

    @TableField("isConsignment")
    private Integer isConsignment;      //是否发货

    public Integer getOrderFormId() {
        return orderFormId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public void setConsignmentTime(Date consignmentTime) {
        this.consignmentTime = consignmentTime;
    }

    public void setOrderFormId(Integer orderFormId) {
        this.orderFormId = orderFormId;
    }

    public String getOrderFromNo() {
        return orderFromNo;
    }

    public void setOrderFromNo(String orderFromNo) {
        this.orderFromNo = orderFromNo;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Integer getIsPayoff() {
        return isPayoff;
    }

    public void setIsPayoff(Integer isPayoff) {
        this.isPayoff = isPayoff;
    }

    public Integer getIsConsignment() {
        return isConsignment;
    }

    public void setIsConsignment(Integer isConsignment) {
        this.isConsignment = isConsignment;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    @Override
    public String toString() {
        return "Orderform{" +
                "orderFormId=" + orderFormId +
                ", user=" + user +
                ", orderFromNo='" + orderFromNo + '\'' +
                ", submitTime=" + submitTime +
                ", consignmentTime=" + consignmentTime +
                ", totalPrice=" + totalPrice +
                ", remark='" + remark + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", isPayoff=" + isPayoff +
                ", isConsignment=" + isConsignment +
                '}';
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public Date getConsignmentTime() {
        return consignmentTime;
    }
}
