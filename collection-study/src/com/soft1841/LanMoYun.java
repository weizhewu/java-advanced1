package com.soft1841;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanMoYun {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit(33.3,"西瓜"));
        Map<String,List<Fruit>> map = new HashMap<>();
        map.put("水果",fruitList);




    }
}
