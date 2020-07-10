package com.psfd.springboot.eshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String username;        //用户名

    private String password;        //密码

    private String name;            //姓名

    private byte sex;               //性别

    private String address;         //地址

    private String phone;           //联系电话

    private String post;            //邮寄地址

    private String email;           //email地址

    private Date regTime;           //注册时间

    private String regIpAddress;       //注册IP地址

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getRegIpAddress() {
        return regIpAddress;
    }

    public void setRegIpAddress(String regIpAddress) {
        this.regIpAddress = regIpAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username=" + username +
                ", password=" + password +
                ", name=" + name +
                ", sex=" + sex +
                ", address=" + address +
                ", phone=" + phone +
                ", post=" + post +
                ", email=" + email +
                ", regTime=" + regTime +
                ", regIpAddress=" + regIpAddress +
                "}";
    }
}
