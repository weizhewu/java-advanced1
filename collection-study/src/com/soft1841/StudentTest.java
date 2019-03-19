package com.soft1841;

import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1.add(new Student(1,"风"));
        list1.add(new Student(2,"水"));
        list2.add(new Student(3,"火"));
        list2.add(new Student(4,"山"));
        Map<String,List<Student>> map = new HashMap<>();
        map.put("男生    ",list1);
        map.put("女生    ",list2);
        Iterator<Map.Entry<String, List<Student>>> iterator = map.entrySet().iterator();
        System.out.println("*******按性别输出的结果********");
        while (iterator.hasNext()){
            Map.Entry<String, List<Student>> entry = iterator.next();
            System.out.println(entry.getKey());
            List<Student> list = entry.getValue();
            for (Student s :list){
                System.out.print(s.getXuehao()+"    "+s.getName());
                System.out.println();
            }
//            Iterator<Student> listIterator = entry.getValue().iterator();
//            while (listIterator.hasNext()){
//                System.out.println(listIterator.next());
//            }


//            list.forEach(student -> {
//                System.out.print(student.getXuehao()+"   "+student.getName());
//                System.out.println();
//            });


        }
    }
}
