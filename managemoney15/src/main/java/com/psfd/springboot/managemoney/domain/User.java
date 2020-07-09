package com.psfd.springboot.managemoney.domain;

import netscape.security.PrivilegeTable;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int quanxian;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(int quanxian) {
        this.quanxian = quanxian;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", quanxian=" + quanxian +
                '}';
    }
}
