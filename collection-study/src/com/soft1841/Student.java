package com.soft1841;

public class Student {
    private int xuehao;
    private String name;

    public Student() {
    }

    public Student(int xuehao, String name) {
        this.xuehao = xuehao;
        this.name = name;
    }

    public int getXuehao() {
        return xuehao;
    }

    public void setXuehao(int xuehao) {
        this.xuehao = xuehao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                xuehao +
                 name
                ;
    }
}
