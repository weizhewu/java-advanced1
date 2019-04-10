package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class NumFrame extends JFrame {
    private JLabel numberLabel;
    private JLabel timeLabel;
    private JPanel movePane;
    private JPanel movePane1;
    private JPanel movePane2;
    public NumFrame(){
        init();
        setTitle("试验窗体");
        setSize(640,480);
        setLocationRelativeTo(null);
        //窗口大小不可变
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        Font font = new Font("微软雅黑",Font.PLAIN,30);
        //numberLabel
        numberLabel = new JLabel();
        numberLabel.setFont(font);
        numberLabel.setText("随机数：");
        add(numberLabel,BorderLayout.NORTH);
        NumThread numThread = new NumThread();
        numThread.setNumberLabel(numberLabel);
        numThread.start();
        //timeLabel
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        add(timeLabel,BorderLayout.SOUTH);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        //左边的movePane
        movePane = new JPanel();
        add(movePane,BorderLayout.WEST);
        RgbThread rgbThread = new RgbThread();
        rgbThread.setMovePane(movePane);
        rgbThread.start();
        //右边的movePane
        movePane1 = new JPanel();
        add(movePane1,BorderLayout.EAST);
        RgbThread1 rgbThread1 = new RgbThread1();
        rgbThread1.setMovePane1(movePane1);
        rgbThread1.start();
        //中间的的movePane
        movePane2 = new JPanel();
        add(movePane2,BorderLayout.CENTER);
        RgbThread2 rgbThread2 = new RgbThread2();
        rgbThread2.setMovePane2(movePane1);
        rgbThread2.start();
    }
    public static void main(String[] args) {
        new NumFrame();
    }
}
