package com.soft1841.lanmoyun;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Map<String, String>> input = new ArrayList<Map<String, String>>();
        Set<Integer> set = new TreeSet<Integer>();
        //循环获取控制台输入的值,直接回车跳出
        Scanner sc = new Scanner(System.in);
        for(;;){
            System.out.print("请输入商品名字和价格,以一个空格分开（直接回车结束输入）：");
            String s = sc.nextLine();
            if(s.equals("")){
                System.out.println("已结束输入！");
                break;
            }
            Map<String, String> map = new HashMap<String, String>();
            //将输入的值通过空格切割为字符串数组
            String[] s1 = s.split(" ");
            map.put(s1[0],s1[1]);
            //把成绩放入set中,后面用来排序
            set.add(Integer.parseInt(s1[1]));
            input.add(map);
        }
        System.out.println("商品名:    价格:");
        //循环list,遍历里面装的map,再遍历map获取每个人对应的成绩,打印
        for(int i = 0; i < input.size(); i++){
            Map<String, String> map1 = input.get(i);
            for (String key:map1.keySet()) {
                System.out.println(key+"       "+map1.get(key));
            }
        }
        //对set进行升序排列
        Set<Integer> sortSet = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //升序
                return o1.compareTo(o2);
            }
        });
        System.out.println("价格从低到高依次排列为:");
        sortSet.addAll(set);
        System.out.println(set);
        for (Integer value : set) {
            System.out.println(value);
        }

        sc.close();
    }

}