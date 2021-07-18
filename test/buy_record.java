package com.example.wind_and_liberty.myapplication0.test;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * Created by wind_and_liberty on 19-12-6.
 */

public class buy_record extends DataSupport {
    private int id;
    @Column(nullable = false)
    private int book_id;
    @Column(nullable = false)
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private double cost;

    public double getCost() {
        return cost;
    }

    public void setCost(double Value) {
        this.cost = Value;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}