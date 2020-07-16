package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_producttype")
public class ProductType {

    @TableId(type = IdType.INPUT)
    private Integer typeid;//产品类型编号

    private String typename;//产品类型名称

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
