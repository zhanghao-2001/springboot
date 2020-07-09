package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_product")
public class Product {

    @TableId(type = IdType.AUTO)
    private Integer productNo;//产品编号
    private Integer productTypeNo;//产品所属类型编号
    private String productName;//产品名称
    private String producingArea;//产品所在区域
    private String productOwner;//产品所有者
    private String unit;//产品单位
    private Byte price;//产品价格
    private Integer quantity;//产品数量
    private String otherInfo;//产品其他信息

    public Integer getProductNo() {
        return productNo;
    }

    public void setProductNo(Integer productNo) {
        this.productNo = productNo;
    }

    public Integer getProductTypeNo() {
        return productTypeNo;
    }

    public void setProductTypeNo(Integer productTypeNo) {
        this.productTypeNo = productTypeNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducingArea() {
        return producingArea;
    }

    public void setProducingArea(String producingArea) {
        this.producingArea = producingArea;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Byte getPrice() {
        return price;
    }

    public void setPrice(Byte price) {
        this.price = price;
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
        return "Product{" +
                "productNo=" + productNo +
                ", productTypeNo=" + productTypeNo +
                ", productName='" + productName + '\'' +
                ", producingArea='" + producingArea + '\'' +
                ", productOwner='" + productOwner + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
