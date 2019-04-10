package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class RgbThread1 extends Thread{
    private JPanel movePane1;
    public void setMovePane1(JPanel movePane1){
        this.movePane1=movePane1;
    }
    @Override
    public void run(){
        Random random = new Random();
        while (true){
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            movePane1.setBackground(new Color(r,g,b));
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
