package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;

public class NetFrame extends JFrame {
    private Box box = Box.createVerticalBox();
    private JLabel jLabel;
    private JLabel wordLabel;
    private JProgressBar progressBar = new JProgressBar();
    public NetFrame(){
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString("音乐正在加载");
        box.add(progressBar);
        add(box,BorderLayout.SOUTH);
        init();
        setTitle("轮播窗体");
        setSize(1050,800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        Font font = new Font("微软雅黑",Font.PLAIN,30);
        jLabel = new JLabel();
        add(jLabel, BorderLayout.CENTER);
        NetThread nt = new NetThread();
        nt.setjLabel(jLabel);
        new Thread(nt).start();
        //wordLabel
        wordLabel = new JLabel();
        wordLabel.setFont(font);
        add(wordLabel,BorderLayout.NORTH);
        WordThread wt = new WordThread();
        wt.setWordLabel(wordLabel);
        new Thread(wt).start();

    }

    public static void main(String[] args) {
        new NetFrame();
    }

}
