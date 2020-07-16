package com.psfd.springboot.offer.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_customer")
public class Customer {

    @TableId(type = IdType.AUTO)
    private Integer id;//客户编号
    private String name;//客户名称
    private String phone;//联系电话
    private String address;//联系地址
    private String relationman;//联系人
    private String otherinfo;//客户其他信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", relationman='" + relationman + '\'' +
                ", otherinfo='" + otherinfo + '\'' +
                '}';
    }
}
