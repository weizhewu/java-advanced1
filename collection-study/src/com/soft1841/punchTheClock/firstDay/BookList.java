package com.soft1841.punchTheClock.firstDay;

import com.soft1841.punchTheClock.firstDay.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookList {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1,"张三",32));
        list.add(new Book(2,"李四",15));
        System.out.println(list);

        //for循环
        for (int i =0,length = list.size();i<length;i++){
            System.out.println(list.get(i));
        }

        //Iterator迭代器
        Iterator<Book> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }

        //Lambda表达式
        list.forEach(book -> System.out.println(book));
    }
}
