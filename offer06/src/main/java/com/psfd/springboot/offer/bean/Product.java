package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_product")
public class Product {

    @TableId(type = IdType.AUTO)
    private Integer productid;//产品编号
    private Integer typeid;//产品所属类型编号
    private String name;//产品名称
    private String area;//产品所在区域
    private String owner;//产品所有者
    private String unit;//产品单位
    private Integer price;//产品价格
    private Integer quantity;//产品数量
    private String otherinfo;//产品其他信息

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", typeid=" + typeid +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", owner='" + owner + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", otherInfo='" + otherinfo + '\'' +
                '}';
    }
}
