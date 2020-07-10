package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_producttype")
public class Producttype {

    @TableId(type = IdType.INPUT)
    private Integer producttypeNo;//产品类型编号

    private String producttypeName;//产品类型名称

    public Integer getProducttypeNo() {
        return producttypeNo;
    }

    public void setProducttypeNo(Integer producttypeNo) {
        this.producttypeNo = producttypeNo;
    }

    public String getProducttypeName() {
        return producttypeName;
    }

    public void setProducttypeName(String producttypeName) {
        this.producttypeName = producttypeName;
    }

    @Override
    public String toString() {
        return "Producttype{" +
                "producttypeNo=" + producttypeNo +
                ", producttypeName='" + producttypeName + '\'' +
                '}';
    }
}
