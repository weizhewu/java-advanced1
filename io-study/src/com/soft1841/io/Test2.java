package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String a= scanner.nextLine();
        File destFile = new File("D:/test123.txt");
        byte[] bytes = a.getBytes();
        OutputStream b = new FileOutputStream(destFile);
        b.write(bytes);
        b.close();
    }
}
