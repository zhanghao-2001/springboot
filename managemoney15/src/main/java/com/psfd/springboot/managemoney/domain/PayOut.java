package com.psfd.springboot.managemoney.domain;

public class PayOut {
    private int payOutId;
    private String payOutName;
    private float payOutMoney;
    private String payOutDate;
    private int userId;

    public int getPayOutId() {
        return payOutId;
    }

    public void setPayOutId(int payOutId) {
        this.payOutId = payOutId;
    }

    public String getPayOutName() {
        return payOutName;
    }

    public void setPayOutName(String payOutName) {
        this.payOutName = payOutName;
    }

    public float getPayOutMoney() {
        return payOutMoney;
    }

    public void setPayOutMoney(float payOutMoney) {
        this.payOutMoney = payOutMoney;
    }

    public String getPayOutDate() {
        return payOutDate;
    }

    public void setPayOutDate(String payOutDate) {
        this.payOutDate = payOutDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PayOut{" +
                "payOutId=" + payOutId +
                ", payOutName='" + payOutName + '\'' +
                ", payOutMoney=" + payOutMoney +
                ", payOutDate='" + payOutDate + '\'' +
                ", userId=" + userId +
                '}';
    }
}
