package com.soft1841.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(-5);
        set.add(-7);
        set.add(10);
        set.add(6);
        set.add(3);
        Iterator<Integer> it = set.iterator();
        System.out.print("Set集合中的元素：");
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
    }
}
