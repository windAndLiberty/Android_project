package com.example.wind_and_liberty.myapplication0.test;


import org.litepal.LitePal;
import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

    public class Book extends DataSupport{
    private int id;
        @Column(nullable = false)
    private double price;
        @Column(unique = true,nullable = false)
    private String name;
        @Column(defaultValue = "unknown")
    private String category;
        @Column(nullable = false)
    private int count;

    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
