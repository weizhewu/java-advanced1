package punchTheClock.thirdDay;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class Distance {
    public static void main(String[] args) throws IOException {

        //在图片缓冲区生成一个图片对象
        BufferedImage bufferedImage = new BufferedImage(
                1024,
                768,
                BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();

        //设置字体
        Font font=new Font("微软雅黑",Font.BOLD,16);
        g.setFont(font);
        g.setColor(Color.white);
        //开始绘制,充满图片缓冲区
        g.fillRect(0,0,1024,768);
        Random random = new Random();
        int a,b,c,d;
        a=random.nextInt(1024);
        b=random.nextInt(768);
        c=random.nextInt(1024);
        d=random.nextInt(768);
        int s = (a-c)^2+(b-d)^2;
        System.out.printf("两点间的距离为："+"%.2f",+Math.sqrt(s));
        //绘制黑色文字
        g.setColor(Color.BLACK);
        String str = "两点间的距离为："+Math.sqrt(s);
        g.drawString(str,17,26);
        g.setColor(Color.black);
        g.drawLine(a,b,c,d);
        //输出图片
        File file = new File("D:/distance.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写到文件
        ImageIO.write(bufferedImage,"jpg",outputStream);
        //关闭输出流
        outputStream.close();


    }
}
