package com.psfd.springboot.eshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2020-07-10
 */
public class Stipend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Float basic;

    private Float eat;

    private Float house;

    private Float duty;

    private Float scot;

    private Float punishment;

    private Float other;

    private LocalDateTime granttime;

    private Float totalize;

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
    public Float getBasic() {
        return basic;
    }

    public void setBasic(Float basic) {
        this.basic = basic;
    }
    public Float getEat() {
        return eat;
    }

    public void setEat(Float eat) {
        this.eat = eat;
    }
    public Float getHouse() {
        return house;
    }

    public void setHouse(Float house) {
        this.house = house;
    }
    public Float getDuty() {
        return duty;
    }

    public void setDuty(Float duty) {
        this.duty = duty;
    }
    public Float getScot() {
        return scot;
    }

    public void setScot(Float scot) {
        this.scot = scot;
    }
    public Float getPunishment() {
        return punishment;
    }

    public void setPunishment(Float punishment) {
        this.punishment = punishment;
    }
    public Float getOther() {
        return other;
    }

    public void setOther(Float other) {
        this.other = other;
    }
    public LocalDateTime getGranttime() {
        return granttime;
    }

    public void setGranttime(LocalDateTime granttime) {
        this.granttime = granttime;
    }
    public Float getTotalize() {
        return totalize;
    }

    public void setTotalize(Float totalize) {
        this.totalize = totalize;
    }

    @Override
    public String toString() {
        return "Stipend{" +
        "id=" + id +
        ", name=" + name +
        ", basic=" + basic +
        ", eat=" + eat +
        ", house=" + house +
        ", duty=" + duty +
        ", scot=" + scot +
        ", punishment=" + punishment +
        ", other=" + other +
        ", granttime=" + granttime +
        ", totalize=" + totalize +
        "}";
    }
}
