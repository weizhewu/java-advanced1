package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FolderTest {
    public static void main(String[] args) {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date currentTime = new Date();
        String a = format.format(currentTime);
        String path = "E:\\"+a;
        File folder = new File(path+"\\");
        if (!folder.exists()){
            folder.mkdirs();
        }
        File file = new File(folder+"/","hello_"+a+"test");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
