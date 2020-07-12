package com.psfd.springboot.eshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 * 商品信息表
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;                //商品编号

    private Commodityclass commodityClass;     //商品种类

    private String commodityName;               //商品名称

    private String manufacturer;               //生产厂家

    private String commodityDepict;               //商品描述

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCommodityDepict() {
        return commodityDepict;
    }

    public void setCommodityDepict(String commodityDepict) {
        this.commodityDepict = commodityDepict;
    }

    private Double commdityPrice;           //商品价格

    private Double fcPrice;                 //帆城网价格

    private Integer commodityAmount;        //商品总数量

    private Integer commodityLeaveNum;      //商品剩余数量

    private Date regTime;   //商品上架时间


    private String image;     //商品图片

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Commodityclass getCommodityClass() {
        return commodityClass;
    }

    public void setCommodityClass(Commodityclass commodityClass) {
        this.commodityClass = commodityClass;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getCommdityPrice() {
        return commdityPrice;
    }

    public void setCommdityPrice(Double commdityPrice) {
        this.commdityPrice = commdityPrice;
    }

    public Double getFcPrice() {
        return fcPrice;
    }

    public void setFcPrice(Double fcPrice) {
        this.fcPrice = fcPrice;
    }

    public Integer getCommodityAmount() {
        return commodityAmount;
    }

    public void setCommodityAmount(Integer commodityAmount) {
        this.commodityAmount = commodityAmount;
    }

    public Integer getCommodityLeaveNum() {
        return commodityLeaveNum;
    }

    public void setCommodityLeaveNum(Integer commodityLeaveNum) {
        this.commodityLeaveNum = commodityLeaveNum;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
}
