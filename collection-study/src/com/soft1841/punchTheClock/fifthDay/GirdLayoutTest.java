package com.soft1841.punchTheClock.fifthDay;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GirdLayoutTest extends JFrame {
    //定义一个数组面板
    private  JPanel[] panels;
    private  GirdLayoutTest(){
        init();
        setTitle("GirdLayout网格布局管理器");
        //界面启动最大化
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public  void init(){
        //将整个容器背景设置为白色
        getContentPane().setBackground(new Color(255,255,255));
        //定义三行三列九宫格，放置9个面板
        GridLayout gridLayout = new GridLayout(3, 3, 50, 30);
        setLayout(gridLayout);
        //创建面板数组
        panels = new JPanel[9];
        //循环创建每个面板对象
        for (int i = 0; i<9; i++){
            panels[i] = new JPanel();
            //面板加上边框
            panels[i].setBorder(BorderFactory.createTitledBorder("面板"+ (i+1)));
            //面板一次加入网格布局管理器，变成九宫格
            add(panels[i]);
        }
        //设置第一个面板背景色，其布局方式默认为FlowLayout居中对齐
        panels[0].setBackground(new Color(178,223,219));
        //在第一个面板内加入5个按钮
        for (int i= 0;i<5;i++){
            panels[0].add(new JButton("Java" ));
        }
        //设置第二个面板为BorderLayout边界布局，设置背景色
        panels[1].setLayout(new BorderLayout(20,20));
        panels[1].setBackground(new Color(0,172,193));
        //5个方向加入按钮
        panels[1].add(new JButton("北"),BorderLayout.NORTH);
        panels[1].add(new JButton("南"),BorderLayout.SOUTH);
        panels[1].add(new JButton("东"),BorderLayout.EAST);
        panels[1].add(new JButton("西"),BorderLayout.WEST);
        panels[1].add(new JButton("中"),BorderLayout.CENTER);

        //设置第三个面板为GirdLayout网格布局，设置背景色
        panels[2].setLayout(new GridLayout(3,3,10,10));
        panels[2].setBackground(new Color(77,182,172));
        //依次加入9个按钮
        for (int i =0;i<9;i++){
            panels[2].add(new JButton(String.valueOf(i+1)));
        }

        //设置第四个面板
        panels[3].setLayout(new BorderLayout(20,20));
        panels[3].setBackground(new Color(57, 145, 216));
        panels[3].add(new JLabel("加油"));

        //设置第五个面板
       panels[4].setLayout(new FlowLayout(5));
       panels[4].setBackground(new Color(43, 43, 43));
       JFrame j = new JFrame();
       j.setBounds(300,200,400,100);
       JPanel j2= new JPanel();
       JComboBox j3 = new JComboBox();
       j3.addItem("吃饭");
       j3.addItem("玩手机");
       j3.addItem("学习");
       j3.setSize(60,50);
       j2.add(j3);
       j.add(j2);
       j.setVisible(true);
       j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       panels[4].add(j3,BorderLayout.CENTER);

        //6
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date currentTime = new Date();
        String a = format.format(currentTime);
        JTextField j11 = new JTextField(a);
        panels[5].add(j11,BorderLayout.NORTH);



        //7
        panels[6].setLayout(new FlowLayout(5));
        setBounds(100,100,170,110);
        JFrame j111 = new JFrame();
        j111.setBounds(300,200,400,100);
        JPanel j222= new JPanel();
        JCheckBox j333 = new JCheckBox("1");
        JCheckBox j3331 = new JCheckBox("2");
        JCheckBox j3332 = new JCheckBox("3");
        j222.add(j333);
        j222.add(j3331);
        j222.add(j3332);
        j111.add(j222);
        j111.setVisible(true);
        j111.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panels[6].add(j222,BorderLayout.CENTER);
        panels[6].setBackground(new Color(89, 77, 17));

        //8
        panels[7].setLayout(new BorderLayout(20,20));
        panels[7].setBackground(new Color(255, 205, 66));
        //5个方向加入按钮
        panels[7].add(new JButton("北丐"),BorderLayout.NORTH);
        panels[7].add(new JButton("南帝"),BorderLayout.SOUTH);
        panels[7].add(new JButton("东邪"),BorderLayout.EAST);
        panels[7].add(new JButton("西毒"),BorderLayout.WEST);
        panels[7].add(new JButton("中神通"),BorderLayout.CENTER);

        //9
        panels[8].setLayout(new BorderLayout(20,20));
        panels[8].setBackground(new Color(137, 33, 192));
        panels[8].add(new JLabel("学习使我快乐"));











    }


    public static void main(String[] args) {
        //用系统样式替代swing默认样式
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        new GirdLayoutTest();
    }

}


