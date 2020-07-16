package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Date;

@TableName("tb_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer orderNo;//订单编号
    private Integer customerNo;//下单客户编号
    private Integer productNo;//下单产品编号
    private Date orderTime;//下单时间
    private Integer quantity;//产品数量
    private String otherInfo;//订单其他信息

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    public Integer getProductNo() {
        return productNo;
    }

    public void setProductNo(Integer productNo) {
        this.productNo = productNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo=" + orderNo +
                ", customerNo=" + customerNo +
                ", productNo=" + productNo +
                ", orderTime=" + orderTime +
                ", quantity=" + quantity +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
