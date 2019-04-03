package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

/**
 * 使用图片布局实现多图浏览功能
 * @author 位哲武
 * 2019/4/2
 */

public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn,preBtn,nextBtn,firstBtn,lastBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel,bottomPanel;
    private CardLayout cardLayout;
    public ImageViewerFrame(){
        init();
        setTitle("使用卡片布局实现多图浏览功能");
        setSize(new Dimension(1024,768));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        //创建底部面板
        bottomPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        firstBtn = new JButton("第一张");
        lastBtn = new JButton("最后一张");
        bottomPanel.add(chooseBtn);
        bottomPanel.add(firstBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        bottomPanel.add(lastBtn);
        chooseBtn.addActionListener(this);
        firstBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        lastBtn.addActionListener(this);
        add(bottomPanel,BorderLayout.SOUTH);
        //创建中间面板，并设置布局为卡片布局
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(53, 144, 193));
        add(centerPanel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new ImageViewerFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseBtn){
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:\\img"));
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
        if (e.getSource() == preBtn){
            cardLayout.previous(centerPanel);
        }
        if (e.getSource() == nextBtn){
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == firstBtn){
            cardLayout.first(centerPanel);
        }
        if (e.getSource() == lastBtn){
            cardLayout.last(centerPanel);
        }
    }
}
