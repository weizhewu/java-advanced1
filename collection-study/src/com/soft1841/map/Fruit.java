package com.soft1841.map;

public class Fruit {
    private Double price;
    private String name;

    public Fruit() {
    }

    public Fruit(Double price, String name) {
        this.price = price;
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
