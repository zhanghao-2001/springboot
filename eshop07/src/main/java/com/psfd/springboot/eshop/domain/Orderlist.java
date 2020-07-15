package com.psfd.springboot.eshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public class Orderlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_list_id", type = IdType.AUTO)
    private Integer orderListId;        //订单列表编号

    private Commodity commodity;        //商品信息

    private Orderform orderForm;        //订单信息

    private Integer amount;             //商品数量

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Orderform getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(Orderform orderForm) {
        this.orderForm = orderForm;
    }
}
