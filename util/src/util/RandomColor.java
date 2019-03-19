package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 随机颜色练习
 * @author 位哲武
 * 2019.3.12
 */

public class RandomColor {
    public static void main(String[] args)throws IOException {
        //随机数种子
        Random random = new Random();
        //生成redRandom随机值
        int redRandom=random.nextInt(256);
        //生成greenRandom随机值
        int greenRandom=random.nextInt(256);
        //生成blueRandom随机值
        int blueRandom=random.nextInt(256);
        System.out.println("R:"+redRandom+",G:"+greenRandom+",B:"+blueRandom);
        //开始用随机色值绘制图片
        //在图片缓冲区生成一个图片对象
        BufferedImage bufferedImage = new BufferedImage(
                75,
                40,
                BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置字体
        Font font=new Font("微软雅黑",Font.BOLD,16);
        g.setFont(font);
        //设置画笔颜色,使用随机生成的颜色
        Color color = new Color(redRandom,greenRandom,blueRandom);
        g.setColor(color);
        //开始绘制,充满图片缓冲区
        g.fillRect(0,0,120,40);

        char[] value = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' ,'A','B','C','D','E','F','G',
                'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','Y','Z'};
        char[] c = new char[4];
        //绘制字符
        for (int i = 0; i < 4; i++) {
            c[i] = value[random.nextInt(62)];
        }
        //绘制黑色文字
        g.setColor(Color.BLACK);
        String str = "";
        str = String.valueOf(c);
        g.drawString(str,17,26);
        for(int i=0;i<16;i++){
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            //画线
            g.drawLine(random.nextInt(70), random.nextInt(340), random.nextInt(70), random.nextInt(40));
        }
        //输出图片
        File file = new File("D:/code.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流写到文件
        ImageIO.write(bufferedImage,"jpg",outputStream);
        //关闭输出流
        outputStream.close();
    }
}
