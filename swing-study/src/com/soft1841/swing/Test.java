package com.soft1841.swing;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
/**
  * @author 老丑
  * @version V1.0
  */
public class Test extends JFrame implements ActionListener{

    //定义所需的组件
//定义文本域
    JTextArea jta;
    //定义菜单条
    JMenuBar jmb;
    //定义菜单
    JMenu jm1;
    JMenuItem jmt1,jmt2;
    JScrollPane jsp;
    public static void main(String[] args) {
// TODO Auto-generated method stub
        Test nb=new Test();
    }
    public Test(){
        super("记事本");
        jta=new JTextArea();
        jmb=new JMenuBar();
        jm1=new JMenu("FILE");
        jmt1=new JMenuItem("打开");
        jmt1.addActionListener(this);
        jmt1.setActionCommand("open");
        jmt2=new JMenuItem("保存");
        jmt2.addActionListener(this);
//设置命令
        jmt2.setActionCommand("save");
//布局，JFrame默认border布局，JPanel默认Float布局，除此之外还有网格布局(GridLayout)，卡片布局
        jsp=new JScrollPane(jta);
        this.setJMenuBar(jmb);
        jmb.add(jm1);
        jm1.add(jmt1);
        jm1.add(jmt2);
        this.add(jsp,BorderLayout.CENTER);
//this.add(jmb,BorderLayout.NORTH);
//设置大小
        this.setSize(400,300);
//设置关闭时，程序自动关闭,其中EXIT_ON_CLOSE相当于3
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//设置可视化,有一次用到com.sum.awt.AWTUilities.setOpacity()来设置透明度
        this.setVisible(true);
    }
    //ActionEvent e 是监听源
    @Override
    public void actionPerformed(ActionEvent e) {

// TODO Auto-generated method stub
        if(e.getSource()==jmt1)//也可以用上述的setActionCommand
        {
//文件选择
            JFileChooser jfc=new JFileChooser();
            FileReader fr=null;
            BufferedReader br=null;
//设置标题
            jfc.setDialogTitle("请选择文件");
//使用默认方式
            jfc.showOpenDialog(null);
            jfc.setVisible(true);
//需要得到用户选择的路径(绝对路径)
            String filename=jfc.getSelectedFile().getAbsolutePath();
            try {
                fr = new FileReader(filename);
                br=new BufferedReader(fr);
//从文件读取信息
                String s="";
                String allcon="";
                while((s=br.readLine())!=null)
                {
                    allcon=allcon+s+"\r\n";//把换行也传入信息
                }
                jta.setText(allcon);
            } catch (Exception e1) {//此处书写不规范
// TODO Auto-generated catch block
                e1.printStackTrace();
            }finally{
                try {
                    if(br!=null)
                    {
                        br.close();
                    }
                    if(fr!=null)
                    {
                        fr.close();
                    }
                } catch (IOException e1) {
// TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
        if(e.getSource()==jmt2)
        {
//文件选择
            JFileChooser jfc=new JFileChooser();
//标题设置
            jfc.setDialogTitle("请选择文件");
            jfc.showSaveDialog(null);
//设置可视化
            jfc.setVisible(true);
//得到文件的路径
            String filename=jfc.getSelectedFile().getAbsolutePath();
//字符流,放在这里，提升了作用域
            FileWriter fw=null;
            BufferedWriter bw=null;
            try {
                fw=new FileWriter(filename);
                bw=new BufferedWriter(fw);
                bw.write(this.jta.getText());
            } catch (Exception e1) {
// TODO Auto-generated catch block
                e1.printStackTrace();
            }finally
            {
                try {
//判断打开的流是否为空，如果不为空则关闭
                    if(bw!=null)
                    {
                        bw.close();
                    }
                    if(fw!=null)
                    {
                        bw.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
