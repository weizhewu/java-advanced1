package com.soft1841.io;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        for (int i =0;i<=10;i++){
            File folder = new File("E:/Test1"+"/"+"cheap"+i);
            if (!folder.exists()){
                folder.mkdirs();
            }else{
                folder.delete();
            }
        }
    }
}
