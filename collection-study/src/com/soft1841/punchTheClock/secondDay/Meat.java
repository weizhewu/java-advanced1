package com.soft1841.punchTheClock.secondDay;

public class Meat implements Comparable<Meat> {
    private String name;
    private Double price;

    public Meat() {
    }

    public Meat(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public int compareTo(Meat meat) {
        return (int) (this.getPrice()-meat.getPrice());
    }
}
