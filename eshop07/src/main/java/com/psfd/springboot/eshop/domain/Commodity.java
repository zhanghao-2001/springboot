package com.psfd.springboot.eshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;

    private Integer commodityClass;

    private String commodiyName;

    private String manufacturer;

    private Double commdityPrice;

    private Double fcPrice;

    private Integer commodityAmount;

    private Integer commodityLeaveNum;

    private LocalDateTime regTime;

    private Blob image;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
    public Integer getCommodityClass() {
        return commodityClass;
    }

    public void setCommodityClass(Integer commodityClass) {
        this.commodityClass = commodityClass;
    }
    public String getCommodiyName() {
        return commodiyName;
    }

    public void setCommodiyName(String commodiyName) {
        this.commodiyName = commodiyName;
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
    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Commodity{" +
        "commodityId=" + commodityId +
        ", commodityClass=" + commodityClass +
        ", commodiyName=" + commodiyName +
        ", manufacturer=" + manufacturer +
        ", commdityPrice=" + commdityPrice +
        ", fcPrice=" + fcPrice +
        ", commodityAmount=" + commodityAmount +
        ", commodityLeaveNum=" + commodityLeaveNum +
        ", regTime=" + regTime +
        ", image=" + image +
        "}";
    }
}
