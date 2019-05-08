package com.soft1841.thread;

import com.soft1841.thread.Demo.JoinDemo;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

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

/**
 * 渐变色背景背景
 */
public class ShadeBackFrame extends JFrame implements ActionListener {
    private JLabel jLabel;
    private int width;
    private int height;
    public ShadeBackFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("渐变色背景窗体");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void init() {
        setLayout(null);
        ShadePanel shadePanel = new ShadePanel();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);

        ImgPanel imgPanel = new ImgPanel();
        imgPanel.setLayout(null);
        imgPanel.setImgPath("thread-study/src/img/1.png");
        imgPanel.setBounds(320, 0, 1300, 1000);

        shadePanel.add(imgPanel);
        add(shadePanel);
        shadePanel.repaint();
    }

    public static void main(String[] args) {
        new ShadeBackFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "播放音乐");
    }
}
/**
 * 继承JPanel的自定义面板，实现渐变背景色，paintComponent重绘组件
 */
class ShadePanel extends JPanel implements Runnable{
    private Color start,end;
    private int r,g,b,n,m,l;

    public ShadePanel(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        java.util.Timer timer = new Timer();
        timer.schedule(timerTask,0,1000);
    }
    @Override
    protected void paintComponent(Graphics g1) {
        Random random = new Random();
        r = random.nextInt(256);
        g = random.nextInt(256);
        b = random.nextInt(256);
        n = random.nextInt(256);
        m = random.nextInt(256);
        l = random.nextInt(256);
        start = new Color(r,g,b);
        end = new Color(n,m,l);
//        Color[] colors = {Color.CYAN,Color.MAGENTA,Color.green,Color.yellow,Color.cyan,Color.magenta};
//        int i = random.nextInt(6);
//        int j = random.nextInt(6);

        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(0, 0, start, 0, height, end);
        g.setPaint(paint);
        g.fillRect(0, 0, width, height);

    }

    @Override
    public void run() {

    }
}

class ClockThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("节目开始");
    }
    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        Thread thread = new Thread(joinDemo);
        Thread.sleep(2000);
        System.out.println("开始倒数");
        for (int i = 10; i>=1;i--){
            Thread.sleep(1000);
            System.out.println(i);
            if (i ==1){
                //main阻塞,thread加入
                thread.start();
                thread.join();
            }
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
        Font font = new Font("微软雅黑",Font.PLAIN,20);
       //在此处填充


    }
}
/**
 * 自定义按钮，绘制背景图
 */
class MyButton extends JButton {
    private String bgIcon;

    public void setBgIcon(String bgIcon) {
        this.bgIcon = bgIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/thread-study/src/img/" + bgIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}