package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

public class InputToFile{
    public static void main(String[] args) throws IOException {
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        //方法1：通过字符流输出
        char[] chars = inputString.toCharArray();
        File destFile1 = new File("E:/result1.txt");
        Writer out1 =  new FileWriter(destFile1,true);
        out1.write(chars);
        out1.close();
        //方法2：通过字节流输出
        byte[] bytes = inputString.getBytes();
        File destFile2 = new File("E:/result2.txt");
        OutputStream out2 = new FileOutputStream(destFile2);
        out2.write(bytes);
        out2.close();
        //方法3：通过打印流输出
        File destFile3 = new File("E:/result3.txt");
        OutputStream  out3 = new FileOutputStream(destFile3);
    }
}
