package com.soft1841.lanmoyun;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        TreeMap<Integer,String> map = new TreeMap<>();
        //录入商品信息:（价格，名字）
        map.put(25,"鸭肉");
        map.put(16,"猪肉");
        map.put(65,"羊肉");
        map.put(23,"鸡肉");
        map.put(55,"牛肉");
        //遍历输出所有商品信息（map集合调动entry方法后利用增强for遍历输出）
        Set<Map.Entry<Integer,String>> goods = map.entrySet();
        System.out.println("名字：\t\t 价格：");
        for (Map.Entry<Integer,String> gs :goods){
            //存入商品价格
            list.add(gs.getKey());
            //输出所有商品的价格
            System.out.println(gs.getValue()+"\t\t"+gs.getKey());
        }
        Collections.sort(list);
        System.out.println("前三名学员的成绩如下：");
        //输出最贵的三件商品
        for (int i = 0;i<=3;i++){
            System.out.println(list.get(list.size()-i));
            for (Map.Entry<Integer,String> gs : goods){
                if (list.get(list.size()-i)==gs.getKey()){
                    //存名字
                    set.add(Integer.valueOf(gs.getValue()));
                    System.out.println(gs.getKey()+"\t\t"+gs.getValue());
                }
            }
        }
        for(Integer in:set) {//遍历set集合
            for(Map.Entry<Integer, String> gs:goods) {//遍历map集合
                if(in==gs.getKey()) {
                    //此处的输出允许前三名有相同的成绩，成绩相同，学号大的往前排
                    System.out.println(in+"\t\t"+gs.getKey());
                }
            }
        }

    }
}
