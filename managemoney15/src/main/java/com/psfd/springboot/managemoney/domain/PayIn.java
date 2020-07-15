package com.psfd.springboot.managemoney.domain;

public class PayIn {
    private int payIn;
    private String payInName;
    private Float payInMoney;
    private String payInDate;
    private int userId;

    public int getPayIn() {
        return payIn;
    }

    public void setPayIn(int payIn) {
        this.payIn = payIn;
    }

    public String getPayInName() {
        return payInName;
    }

    public void setPayInName(String payInName) {
        this.payInName = payInName;
    }

    public Float getPayInMoney() {
        return payInMoney;
    }

    public void setPayInMoney(Float payInMoney) {
        this.payInMoney = payInMoney;
    }

    public String getPayInDate() {
        return payInDate;
    }

    public void setPayInDate(String payInDate) {
        this.payInDate = payInDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PayIn{" +
                "payIn=" + payIn +
                ", payInName='" + payInName + '\'' +
                ", payInMoney=" + payInMoney +
                ", payInDate='" + payInDate + '\'' +
                ", userId=" + userId +
                '}';
    }
}
