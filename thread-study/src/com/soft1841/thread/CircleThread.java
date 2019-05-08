package com.soft1841.thread;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CircleThread extends Applet implements Runnable {
    private JFrame frame;
    private TextArea cA;
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    //左上角起点座标，X 和 Y 相同
    int x = 100;
    int r = 200;
    @Override
    public void run() {
        //同心圆
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < 5 * 80; i += 20) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Graphics g = frame.getGraphics();
                    g.setColor(Color.BLUE);
                    g.drawOval(x + i / 2, x + i / 2, r - i, r - i);
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask1,0,1000);
    }
}
