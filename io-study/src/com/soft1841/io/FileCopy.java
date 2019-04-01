package com.soft1841.io;

import java.io.*;
import java.util.UUID;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //指定源文件
        File srcFile = new File("D:/distance.jpg");
        String srcFileName = srcFile.getName();
        int position = srcFileName.indexOf(".");
        //取得源文件的扩展名
        String suffixName = srcFileName.substring(position+1);
        //新的主文件名
        String newName = UUID.randomUUID().toString();
        //指定目标文件
        File endFile = new File("E:/"+newName+"."+suffixName);
        //创建一个字节数组，大小为源文件长度，长度转化为int
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream a = new FileInputStream(srcFile);
        //创建字节输出流
        a.read(bytes);
        a.close();
        //将字节数组输出到目标文件
        OutputStream b = new FileOutputStream(endFile);
        b.write(bytes);
        b.close();
    }
}
