package com.soft1841.thread.randomRgb;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class RgbThread2 extends Thread{
    private JPanel movePane2;
    public void setMovePane2(JPanel movePane2){
        this.movePane2=movePane2;
    }
    @Override
    public void run(){
        Random random = new Random();
        while (true){
            int x = random.nextInt(640);
            int y = random.nextInt(480);
            movePane2.setBounds(x,y,80,80);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
