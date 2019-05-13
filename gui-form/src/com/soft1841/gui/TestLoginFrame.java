package com.soft1841.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestLoginFrame {
    private JPanel mainPanel;
    private JLabel bannerLabel;
    private JLabel avatarLabel;
    private JTextField accountField;
    private JTextField passwordField;
    private JCheckBox 记住密码CheckBox;
    private JCheckBox 自动登录CheckBox;
    private JButton loginBtn;

    public TestLoginFrame() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"登陆成功");
            }
        });
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        JFrame frame = new JFrame("TestLoginFrame");
        frame.setContentPane(new TestLoginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //窗体自适应容器大小
//        frame.pack();
        frame.setSize(640,480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
