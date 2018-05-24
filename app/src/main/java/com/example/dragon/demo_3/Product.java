package com.example.dragon.demo_3;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private double price;
    private int year;

    public Product() {

    }

    public Product(String code, String name, double price, int year) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
