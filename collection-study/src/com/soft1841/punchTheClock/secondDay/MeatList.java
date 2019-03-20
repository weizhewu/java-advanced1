package com.soft1841.punchTheClock.secondDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeatList {
    public static void main(String[] args) {
        List<Meat> list = new ArrayList<>();
        list.add(new Meat("猪肉",23.0));
        list.add(new Meat("鸡肉",20.5));
        list.add(new Meat("牛肉",56.8));
        list.add(new Meat("羊肉",65.3));
        list.add(new Meat("鱼肉",17.6));
        Collections.sort(list);
        for (Meat meat:list){
            System.out.println("名字:"+meat.getName()+"     "+"价格:"+meat.getPrice());
        }


    }
}
