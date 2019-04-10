package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumThread extends Thread{
    private JLabel numberLabel;
    public void setNumberLabel(JLabel numberLabel) {
        this.numberLabel = numberLabel;
    }
    @Override
    public void run(){
        Random random = new Random();
        while (true){
            int num = random.nextInt(1000000000);
            numberLabel.setText("随机数："+String.valueOf(num));
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            numberLabel.setBackground(new Color(r,g,b));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
