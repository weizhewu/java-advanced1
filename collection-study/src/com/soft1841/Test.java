package com.soft1841;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author 点九博客
 * 1. 给定6名学生的考试分数录入到Map中，以学号作为key，分数作为value;
 * 打印该6名学生及对应的分数；并按分数显示前三名学员学号与成绩(选做题)
 * 思路：综合Map、List、Set应用---使用Collections工具对List排序
 * 分析：分数是无序可重复的----ArrayList
 * 		学号是唯一的且按分数排序----TreeSet
 * 		学号、分数存到Map中
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            //4、匿名内部类实现学号排序
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2-i1;//分数相同的话，学号由高到低
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //1、录入学生信息（map集合）
        map.put(1, 66);
        map.put(2, 83);
        map.put(3, 72);
        map.put(4, 96);
        map.put(5, 51);
        map.put(6, 94);
        //2、遍历输出所有学生信息（map集合调动entry方法后利用增强for遍历输出）
        Set<Entry<Integer, Integer>> ent = map.entrySet();
        System.out.println("学号：\t\t成绩：");
        for(Entry<Integer, Integer> e:ent) {
            //存成绩
            list.add(e.getValue());
            //输出所有学生的成绩（按录入顺序输出，未排序）
            System.out.println(e.getKey()+"\t\t"+e.getValue());
        }
        //3、输出分数前三名的学生信息，集合的工具类进行排序
        Collections.sort(list);
        System.out.println("前三名学员的成绩如下：");
        //输出前三名的成绩（成绩由高到低的输出）
        for(int i=1;i<=3;i++) {//只输出三名学生
            //System.out.println(list.get(list.size()-i));
            for(Entry<Integer, Integer> e:ent) {//遍历map集合
                if(list.get(list.size()-i)==e.getValue()) {//获取前三名的学号
                    //存学号
                    set.add(e.getKey());
                    //这里的输出语句在前三名无重复时可用
                    //System.out.println(e.getKey()+"\t\t"+e.getValue());
                }
            }
        }
        //4、成绩相同，学号靠前先输出--调用了set集合通过匿名内部类实现的排序方法
        for(Integer in:set) {//遍历set集合
            for(Entry<Integer, Integer> e:ent) {//遍历map集合
                if(in==e.getKey()) {
                    //此处的输出允许前三名有相同的成绩，成绩相同，学号大的往前排
                    System.out.println(in+"\t\t"+e.getValue());
                }
            }
        }
    }
}
