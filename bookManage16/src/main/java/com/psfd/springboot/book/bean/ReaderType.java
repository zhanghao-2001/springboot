package com.psfd.springboot.book.bean;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Table;

/**
 * @author LuYang
 * @create 2020-07-09 20:34
 */
@TableName("readertype")
public class ReaderType {
    private int id;
    private String name;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ReaderType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
