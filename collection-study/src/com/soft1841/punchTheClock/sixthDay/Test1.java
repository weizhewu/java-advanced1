package com.soft1841.punchTheClock.sixthDay;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test1 {
    private static List<File> getData(String path) {
        List<File> list = new ArrayList<>();
        try {
            File f = new File(path);
            File[] fs = f.listFiles();
            int i = 0;
            while (i<f.length()) {
                if (fs[i].isDirectory())
                    getData(fs[i].getPath());// 递归查询目录下的文件夹
                if (fs[i].getName().endsWith(".jpg"))// 查找xls后缀的文件
                    list.add(fs[i]);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        List<File> list = getData("D:\\img");
        for (File f : list) {
            System.out.println(f.getName());
        }
    }
}
