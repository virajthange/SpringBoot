package com.spider.postman;

public class Product {
    private Integer pid;
    private String brand;

    public Integer getPid() {
        return pid;
    }

    public String getBrand() {
        return brand;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", brand='" + brand + '\'' +
                '}';
    }
}
