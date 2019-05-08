package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class SingleWordThread extends Thread {
    private TextArea cA;

    public void setcA(TextArea cA) {
        this.cA = cA;
    }
    @Override
    public void run() {
        TimerTask timerTask = new TimerTask() {
            File file = new File("D:/story.txt");
            @Override
            public void run() {
                try {
                    InputStream inputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    //读入内容，到字节数组
                    inputStream.read(bytes);
                    //使用bytes构建一个新的输出字符串
                    String resultStr = new String(bytes);
                    String[] a = {resultStr};
                    for (String b : a){
                        for (int i = 0; i<a.length; i++){
                            cA.append(a[i]);
                        }
                    }

                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,"IO操作异常");
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,0,1500);
    }
}
