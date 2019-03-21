package com.soft1841.lanmoyun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/** 2  定义一个Worker类,属    性:name:String,age:int,salary:double 
 a).把若干Worker对象放在List中,排序并遍历输出
 两种方式      1）利用comparable 接口--》按年龄升序排列
 2）利用comparator接口--》按工资降序排列
 b).把若干Worker对象放在Set中并遍历,要求没有重复元素，内容相同标准（名字和年龄相同）
 c).把若干Worker对象放在Map中，并按照两种方式分别遍历键和值,要求以Worker的姓名作为key，worker对象作为value。
 *
 * */
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class Test {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }
    public static void demo1(){
        List<Worker> list=new ArrayList<Worker>();
        Worker worker1=new Worker("张三",18,5000);
        Worker worker2=new Worker("张三1",19,2000);
        Worker worker3=new Worker("张三2",17,3000);
        Worker worker4=new Worker("张三3",20,4000);
        list.add(worker1);
        list.add(worker2);
        list.add(worker3);
        list.add(worker4);
        System.out.println("排序前：");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("按年龄升序输出：");
        System.out.println(list);

        Collections.sort(list,new WorkerComparator());
        System.out.println("按工资降序输出：");
        System.out.println(list);

    }
    public static void demo2(){
        Set<Worker> set=new HashSet<Worker>();
        Worker worker1=new Worker("张三",18,5000);
        Worker worker2=new Worker("张三1",19,2000);
        Worker worker3=new Worker("张三2",17,3000);
        Worker worker4=new Worker("张三3",20,4000);
        Worker worker5=new Worker("张三",18,5000);
        set.add(worker1);
        set.add(worker2);
        set.add(worker3);
        set.add(worker4);
        set.add(worker5);
        System.out.println("set遍历:");
        for(Worker temp:set){
            System.out.println(temp);
        }
    }
    public static void demo3(){
        Map<String,String> map=new HashMap<String,String>();
        map.put("张三", "18,5000");
        map.put("张三1", "16,4000");
        map.put("张三2", "14,1000");
        map.put("张三3", "19,6000");
        System.out.println("map遍历一：");
        Set<String> keySet=map.keySet();
        for(String key:keySet){
            System.out.println("名字："+key+" 年龄和工资："+map.get(key));
        }
        System.out.println("map遍历二：");
        Set<Entry<String,String>> ss=map.entrySet();
        for(Iterator iterator=ss.iterator();iterator.hasNext();){
            Entry e=(Entry) iterator.next();
            System.out.println("名字："+e.getKey()+" 年龄和工资："+e.getValue());

        }


    }
}
class WorkerComparator implements Comparator{
    public int compare(Object o1,Object o2){
        if(o1 instanceof Worker && o2 instanceof Worker){
            Worker p1=(Worker)o1;
            Worker p2=(Worker)o2;
            if(p1.salary>p2.salary){
                return -1;
            }
            if(p1.salary<p2.salary){
                return 1;
            }
            return 0;
        }
        return 0;
    }
}
class Worker implements Comparable<Worker>{
    String name;
    int age;
    double salary;
    public Worker(String name, int age, double salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "\nWorker [name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
    public int compareTo(Worker o){
        if(this.age>o.age){
            return 1;
        }else if(this.age<o.age){
            return -1;
        }else{
            return 0;
        }
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


}
