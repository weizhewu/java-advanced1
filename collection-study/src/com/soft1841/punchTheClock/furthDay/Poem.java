package com.soft1841.punchTheClock.furthDay;

import javax.swing.*;
import java.awt.*;

public class Poem  extends JFrame {
    public Poem(){
        setTitle("本窗体使用流式布局管理器");
        Container c = getContentPane();
        //设置窗体使用流式布局管理器，使组件右对齐，组件之间的水平间隔为10像素，垂直间隔10像素
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        c.add(new JLabel("下面那句诗是描述夏天的"));
        c.add(new JLabel("A.秋风萧瑟天气凉，草木摇荡露为霜。"));
        c.add(new JLabel("B.白雪纷纷何所似，撒盐空中差可尼。"));
        c.add(new JLabel("C.接天莲叶无穷碧，映日荷花别样红。"));
        c.add(new JLabel("D.竹外桃花三两枝，春江水暖鸭先知。"));
        setSize(300,200);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //设置窗口可见
        setVisible(true);
    }
    public static void main(String[] args) {
        new Poem();
    }
}
