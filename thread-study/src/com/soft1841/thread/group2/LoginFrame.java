package com.soft1841.thread.group2;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LoginFrame extends JFrame implements ActionListener {
    private JLabel accountLabel, passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton confirmButton, cancelButton;
    private int width;
    private int height;
    public LoginFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("登录界面");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        setLayout(null);
        ShadePanel1 shadePanel = new ShadePanel1();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);
        ImgPanel imgPanel = new ImgPanel();
        imgPanel.setImgPath("img/1.png");
        imgPanel.setLayout(null);
        imgPanel.setBounds(700, 200, 500, 400);
        Font font = new Font("仿宋", Font.PLAIN, 30);
        accountLabel = new JLabel("账号:");
        accountLabel.setFont(font);
        accountLabel.setForeground(new Color(4, 4, 4));
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("密码:");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(4, 4, 4));
        passwordField = new JPasswordField();
        passwordField.setFont(font);


        confirmButton = new JButton("确认");
        confirmButton.setFont(font);
        cancelButton = new JButton("取消");
        cancelButton.setFont(font);
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
        accountLabel.setBounds(60, 150, 100, 35);
        accountField.setBounds(200, 150, 260, 35);
        passwordLabel.setBounds(60, 220, 100, 35);
        passwordField.setBounds(200, 220, 260, 35);
        confirmButton.setBounds(100,300,100,35);
        cancelButton.setBounds(280,300,100,35);

        imgPanel.add(accountLabel);
        imgPanel.add(accountField);
        imgPanel.add(passwordLabel);
        imgPanel.add(passwordField);
        imgPanel.add(confirmButton);
        imgPanel.add(cancelButton);
        shadePanel.add(imgPanel);
        add(shadePanel);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton){
            JOptionPane.showMessageDialog(null,"登录成功！");
        }
        if (e.getSource() == cancelButton){
            this.dispose();
        }
    }
}

/**
 * 继承JPanel的自定义面板，绘制背景图
 */
class ImgPanel extends JPanel {
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/thread-study/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
 class ShadePanel1 extends JPanel{
    public ShadePanel1(){
        java.util.Timer timer = new Timer();
        timer.schedule(timerTask,0,2000);

    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            repaint();
        }
    };
    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Color[] color = {Color.CYAN,Color.MAGENTA,Color.pink,Color.orange};
        Random r = new Random();
        int i = r.nextInt(2);
        int j = r.nextInt(3);
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
        g.setPaint(paint);
        g.fillRect(i, j, width, height);
    }
}
