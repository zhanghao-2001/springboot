package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_customer")
public class Customer {

    @TableId(type = IdType.AUTO)
    private Integer customerNo;//客户编号
    private String customerName;//客户名称
    private String phone;//联系电话
    private String address;//联系地址
    private String relationman;//联系人
    private String otherInfo;//客户其他信息

    public Integer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelationman() {
        return relationman;
    }

    public void setRelationman(String relationman) {
        this.relationman = relationman;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNo=" + customerNo +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", relationman='" + relationman + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }
}
