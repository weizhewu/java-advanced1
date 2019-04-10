package com.soft1841.thread.randomRgb;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WordThread extends Thread {
    private JLabel wordLabel;
    private String[]word = {"时间是一切财富中最宝贵的财富。 —— 德奥弗拉斯多",
            "把时间用在思考上是最能节省时间的事情。 —— 卡曾斯",
            "真理惟一可靠的标准就是永远自相符合。 —— 欧文",
            "生活有度，人生添寿。 —— 书摘",
            "没有人不爱惜他的生命，但很少人珍视他的时间。 —— 梁实秋",
            "从不浪费时间的人，没有工夫抱怨时间不够。 —— 杰弗逊"};
    public void setWordLabel(JLabel wordLabel) {
        this.wordLabel = wordLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len = word.length;
        while (true){
            wordLabel.setText(word[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == len) {
                i = 0;
            }
        }

    }
}
