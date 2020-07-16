package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Date;

@TableName("tb_quotation")
public class Quotation {

    @TableId(type = IdType.AUTO)
    private Integer quotationNo;//报价编号
    private Integer customerId;//报价客户编号
    private Integer productId;//报价产品编号
    private String quotationMan;//报价人
    private Date quotationTime;//报价时间
    private String otherInfo;//报价其他信息

    public Integer getQuotationNo() {
        return quotationNo;
    }

    public void setQuotationNo(Integer quotationNo) {
        this.quotationNo = quotationNo;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getQuotationMan() {
        return quotationMan;
    }

    public void setQuotationMan(String quotationMan) {
        this.quotationMan = quotationMan;
    }

    public Date getQuotationTime() {
        return quotationTime;
    }

    public void setQuotationTime(Date quotationTime) {
        this.quotationTime = quotationTime;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "quotationNo=" + quotationNo +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", quotationMan='" + quotationMan + '\'' +
                ", quotationTime=" + quotationTime +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
