import javax.swing.*;
import java.io.*;

/**
 * 从本地加载图片并实现轮播
 */

public class CarouseThread implements Runnable {
    private String[] imgs = {"D:/carouse/1.jpg", "D:/carouse/2.jpg", "D:/carouse/3.jpg", "D:/carouse/4.jpg", "D:/carouse/5.jpg"};
    private JLabel bgLabel;

    public void setBgLabel(JLabel bgLabel) {
        this.bgLabel = bgLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len = imgs.length - 1;
        while (true) {
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == len){
                    i=0;
                }
            } catch (IOException e) {
                System.out.println("IO异常");
            }
        }
    }
}
