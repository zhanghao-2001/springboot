package com.psfd.springboot.book.bean;

import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Date;

/**
 * @author LuYang
 * @create 2020-07-09 20:34
 */
@TableName("bookmassage")
public class BookMassage {
    private int id;
    private String barcode;
    private String bookname;
    private int typeid;
    private String author;
    private String translator;
    private String isbn;
    private float price;
    private int page;
    private int bookcase;
    private Date intime;
    private String operator;
    private int del;

    @Override
    public String toString() {
        return "BookMassage{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", bookname='" + bookname + '\'' +
                ", typeid=" + typeid +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", page=" + page +
                ", bookcase=" + bookcase +
                ", intime=" + intime +
                ", operator='" + operator + '\'' +
                ", del=" + del +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getBookcase() {
        return bookcase;
    }

    public void setBookcase(int bookcase) {
        this.bookcase = bookcase;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }
}
