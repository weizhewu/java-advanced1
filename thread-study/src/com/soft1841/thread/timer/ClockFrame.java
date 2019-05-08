package com.soft1841.thread.timer;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class ClockFrame extends JFrame {
    private JPanel clockPanel;
    private Timer timer ;
    private TimerTask timerTask;
    private JLabel timeLabel;

    public ClockFrame(){
        setTitle("时钟");
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLocation(1000,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void init() throws IOException {
        Font font = new Font("仿宋", Font.BOLD, 20);
        clockPanel = new JPanel(){
            protected  void paintComponent(Graphics g){
                try {
                    Image bg = ImageIO.read(new File("D:/clock.jpg"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };
        clockPanel.setLayout(new FlowLayout(FlowLayout.CENTER,200,200));
        add(clockPanel);
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        add(timeLabel,BorderLayout.SOUTH);

        timerTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                timeLabel.setText(timeString);
                if(timeString.equals("2019-04-16 09:20:45")){
                    JOptionPane.showMessageDialog(null, "时间到~~");
                    this.cancel();
                }
            }
        };
        timer = new Timer();
        timer.schedule(timerTask,0,1000);

    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        new ClockFrame();


    }
}
