package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");
        System.out.println(set);
//        String s1 = new String("A");
//        String s2 = new String("B");
//        String s3 = new String("C");
//        String s4 = new String("A");
//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
//        System.out.println(set);


        //用for循环遍历set集合8j
//
//        for (int i = 0,len = set.size();i<len;i++){
//            System.out.println(set.);
//        }

        //用Iterator迭代器遍历set集合、
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //通过Lambda表达式遍历集合
        set.forEach(str -> System.out.println(str) );

    }
}
