package com.soft1841.swing;
/**
 * 小组作业:IO输入输出流以及Swing界面的综合案例
 * @author 位哲武
 * 2019/4/4
 */

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class GroupFrame extends JFrame implements ActionListener {
    private JPanel bottomPanel,centerPanel;
    private JMenu m1,m2,m3,m4,m5,m6;
    private JMenu n1,n2,n3,n4,n5,n6;
    private JMenuItem n21,n22,n23;
    private JButton a1,a2;
    private CardLayout cardLayout;
    private JFileChooser fileChooser;
    private JTextArea contentArea;
    private JButton confirmButton;
    private JTextField inputField;
    public GroupFrame(){
        init();
        setTitle("王者荣耀");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(650, 350, 665, 445);
    }
    public void init(){
        inputField = new JTextField(20);
        //指定这个框的大小
        inputField.setSize(40,20);
        confirmButton = new JButton("确认");
        confirmButton.addActionListener(this);
        //指定按钮的大小
        confirmButton.setSize(25,20);
        //创建中间面板，并设置布局为卡片布局
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(53, 144, 193));
        add(centerPanel,BorderLayout.WEST);
        //顶部菜单
        m1 = new JMenu("刺客");
        m2 = new JMenu("战士");
        m3 = new JMenu("射手");
        m4 = new JMenu("法师");
        m5 = new JMenu("辅助");
        m6 = new JMenu("坦克");
        JMenuBar m = new JMenuBar();
        m.add(m1);
        m.add(m2);
        m.add(m3);
        m.add(m4);
        m.add(m5);
        m.add(m6);
        m.add(inputField);
        m.add(confirmButton);
        add(m,BorderLayout.NORTH);
        contentArea = new JTextArea();
        add(contentArea,BorderLayout.CENTER);
        n1 = new JMenu("娜可露露");
        n2 = new JMenu("李白");
        n3 = new JMenu("橘右京");
        n4 = new JMenu("关羽");
        n5 = new JMenu("赵云");
        n6 = new JMenu("刘备");
        //刺客菜单
        m1.add(n1);
        m1.add(n2);
        m1.add(n3);
        m1.add(n4);
        m1.add(n5);
        m1.add(n6);
        //底部面板
        bottomPanel = new JPanel();
        a1 = new JButton("下一个");
        a2 = new JButton("撤回");
        bottomPanel.add(a1);
        bottomPanel.add(a2);
        a1.addActionListener(this);
        a2.addActionListener(this);
        add(bottomPanel,BorderLayout.SOUTH);
        //李白面板
        n21 = new JMenuItem("皮肤");
        n21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == n21){
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("D:\\grouptask\\first"));
                    //设置文件为多选模式
                    fileChooser.setMultiSelectionEnabled(true);
                    //打开对话框，阻塞模式
                    int result = fileChooser.showOpenDialog(null);
                    //用户选择了文件
                    if (result == JFileChooser.APPROVE_OPTION){
                        //获取选中的所有文件
                        File[] files = fileChooser.getSelectedFiles();
//                System.out.println(files.length);
                        //遍历文件数组
                        for (File f : files){
                            System.out.println(f.getAbsolutePath());
                            //对每个f文件，创建字节输入流读入字节数组，构建Icon,并设置给JLabel
                            try {
                                byte[] bytes = new byte[(int) f.length()];
                                InputStream inputStream = new FileInputStream(f);
                                inputStream.read(bytes);
                                Icon icon = new ImageIcon(bytes);
                                JLabel imgLabel = new JLabel();
                                imgLabel.setIcon(icon);
                                imgLabel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        System.out.println("图片被点击");
                                    }
                                });
                                centerPanel.add(imgLabel);
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(null,"IO操作异常");
                            }
                        }
                    }

                }

            }
        });
        n22 = new JMenuItem("背景故事");
        n22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == n22){

                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(true);
                    fileChooser.setCurrentDirectory(new File("D:\\grouptask\\second"));
                    int result = fileChooser.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION){
                        File[] files = fileChooser.getSelectedFiles();
                        for (File f : files){
                            System.out.println(f.getAbsolutePath());
                            //对每个f文件，创建字节输入流读入字节数组，构建Icon,并设置给JLabel
                            try {
                                byte[] bytes = new byte[(int) f.length()];
                                InputStream inputStream = new FileInputStream(f);
                                inputStream.read(bytes);
                                Icon icon = new ImageIcon(bytes);
                                JLabel imgLabel = new JLabel();
                                imgLabel.setIcon(icon);
                                imgLabel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        System.out.println("图片被点击");
                                    }
                                });
                                centerPanel.add(imgLabel);
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(null,"IO操作异常");
                            }
                        }
                    }

                }
            }
        });
        n23 = new JMenuItem("台词");
        n23.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == n23){
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("D:\\grouptask\\third"));
                    int result = fileChooser.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION){
                        File[] files = fileChooser.getSelectedFiles();
                        for (File f : files){
                            System.out.println(f.getAbsolutePath());
                            //对每个f文件，创建字节输入流读入字节数组，构建Icon,并设置给JLabel
                            try {
                                byte[] bytes = new byte[(int) f.length()];
                                InputStream inputStream = new FileInputStream(f);
                                inputStream.read(bytes);
                                Icon icon = new ImageIcon(bytes);
                                JLabel imgLabel = new JLabel();
                                imgLabel.setIcon(icon);
                                imgLabel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        System.out.println("图片被点击");
                                    }
                                });
                                centerPanel.add(imgLabel);
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(null,"IO操作异常");
                            }
                        }
                    }
                }
            }
        });
        n2.add(n21);
        n2.add(n22);
        n2.add(n23);
    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new GroupFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == a1){
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == a2){
            cardLayout.previous(centerPanel);
        }
        String filePath = inputField.getText().trim();
        //创建文件
        File file = new File(filePath);
        //使用三种方法将file中的内容读入
        InputStream in;
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            //读入内容 到字节数组
            inputStream.read(bytes);
            //使用bytes构建一个输出字符串
            String resultStr = new String(bytes);
            contentArea.append(resultStr);
//            //追加一次回车换行
            contentArea.append("\r\n");
//
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null,"IO操作异常");
        }
    }

}

