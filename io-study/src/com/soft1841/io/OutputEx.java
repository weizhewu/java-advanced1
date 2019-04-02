package com.soft1841.io;

import java.io.*;

public class OutputEx {
    public static void main(String[] args) throws IOException {
        String str ="I love Java!";
        File file1 = new File("D:\\out1.txt");
        if (!file1.exists()){
            file1.createNewFile();
        }

        //1.通过字节流输出
        OutputStream outputStream = new FileOutputStream(file1,true);
        outputStream.write(str.getBytes());
        outputStream.close();

        //2.字符流
//        Writer writer = new FileWriter(file1,true);
//        writer.write(str.toCharArray());
//        writer.close();

        //3.打印流-包装流
//        OutputStream out = new FileOutputStream(file1,true);
//        PrintStream printStream = new PrintStream(out);
//        printStream.print(str);
//        System.out.println(str);
    }
}
