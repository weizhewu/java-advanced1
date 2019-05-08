package com.soft1841.thread;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * 文件名： Draw.java
 * 说明：画圆演示
 *
 */
public class Draw extends JFrame {
    private static final long serialVersionUID = 1L;
    //自定义的 panel
    MyPanel panel;
    Draw() {
        MyPanel p = new MyPanel();
        this.add(p);
//窗体尺寸
        this.setSize(800, 600);
//显示窗体
        this.setVisible(true);
//按窗体右上角的关闭按钮结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class MyPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        //左上角起点座标，X 和 Y 相同
        int x = 100;
        int r = 200;
        public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < 5 * 20; i += 20) {
                g.drawOval(x + i / 2, x + i / 2, r - i, r - i);
            }
        }
    }
    public static void main(String[] args) {
        new Draw();
    }
}
