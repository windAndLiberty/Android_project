package com.example.wind_and_liberty.myapplication0.test;


import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

//String:  get_TIME: (new java.text.SimpleDateFormat("yyyy-M-d H:mm:ss")).format(new Date())
public class sell_record extends DataSupport {
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
    private double salesValue;

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
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
