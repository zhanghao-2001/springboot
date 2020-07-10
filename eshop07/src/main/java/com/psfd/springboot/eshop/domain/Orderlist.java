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
    private Integer orderListId;

    private Integer commodityId;

    private Integer orderFormId;

    private Integer amount;

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }
    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
    public Integer getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(Integer orderFormId) {
        this.orderFormId = orderFormId;
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Orderlist{" +
        "orderListId=" + orderListId +
        ", commodityId=" + commodityId +
        ", orderFormId=" + orderFormId +
        ", amount=" + amount +
        "}";
    }
}
