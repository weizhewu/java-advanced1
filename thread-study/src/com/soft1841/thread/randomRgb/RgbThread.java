package com.soft1841.thread.randomRgb;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class RgbThread extends Thread{
    private JPanel movePane;
    public void setMovePane(JPanel movePane){
        this.movePane=movePane;
    }
    @Override
    public void run(){
        Random random = new Random();
        while (true){
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            movePane.setBackground(new Color(r,g,b));
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
