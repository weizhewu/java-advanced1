package com.soft1841.io;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 图片窗体程序
 * @author 位哲武
 * 2019.3.26
 */
public class ImageFrame extends JFrame {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imgLabel;
    private JLabel pathLabel;
    private JLabel bigLabel;
    private JLabel timeLabel;
    private Icon icon;

    //构造方法（基本写死的）
    public ImageFrame() throws IOException {
        init();
        setTitle("图片窗体");
        setSize(1000,600);
        setLocationRelativeTo(null);          //窗体自动居中
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //设置布局，放置组件
    public void init() throws IOException {
        topPanel = new JPanel();
        buttons = new JButton[6];
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton("按钮" + i + 1);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imgLabel = new JLabel();
        //读入本地的图片到内存的字节数组
        File srcFile = new File("E:\\1.png");
        InputStream in = new FileInputStream(srcFile);
        byte[] bytes = new byte[(int) srcFile.length()];
        in.read(bytes);
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        add(imgLabel,BorderLayout.CENTER);
        String imgPath = srcFile.getPath();
        pathLabel = new JLabel();
        pathLabel.setText(imgPath);
        add(pathLabel,BorderLayout.SOUTH);
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date localTime = new Date();
        String time = format.format(localTime);
        timeLabel = new JLabel();
        timeLabel.setText(time);
        add(timeLabel,BorderLayout.WEST);

    }

    public static void main(String[] args) throws IOException {
        new ImageFrame();
    }
}
