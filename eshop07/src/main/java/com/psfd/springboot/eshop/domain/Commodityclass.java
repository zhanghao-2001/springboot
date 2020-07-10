package com.psfd.springboot.eshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 商品种类信息
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public class Commodityclass implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "commodity_classId", type = IdType.AUTO)
    private Integer commodityClassid;       //商品种类编号

    private String commodityClassName;      //商品种类名称

    public Integer getCommodityClassid() {
        return commodityClassid;
    }

    public void setCommodityClassid(Integer commodityClassid) {
        this.commodityClassid = commodityClassid;
    }

    public String getCommodityClassName() {
        return commodityClassName;
    }

    public void setCommodityClassName(String commodityClassName) {
        this.commodityClassName = commodityClassName;
    }

    @Override
    public String toString() {
        return "Commodityclass{" +
                "commodityClassid=" + commodityClassid +
                ", commodityClassName=" + commodityClassName +
                "}";
    }
}
