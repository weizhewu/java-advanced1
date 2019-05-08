package com.soft1841.thread;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;

public class CircleFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private TextArea cA;
    public CircleFrame(){
        init();
        this.setSize(800, 600);
        //显示窗体
        this.setVisible(true);
        //按窗体右上角的关闭按钮结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){

        CircleThread circleThread = new CircleThread();
        circleThread.setFrame(this);
        new Thread(circleThread).start();

        cA = new TextArea();
        add(cA,BorderLayout.SOUTH);
        SingleWordThread singleWordThread = new SingleWordThread();
        singleWordThread.setcA(cA);
        new Thread(singleWordThread).start();
    }


    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new CircleFrame();
    }
}
