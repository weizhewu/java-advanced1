package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetThread extends Object implements Runnable{
    private String[] s = {"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554805718197&di=45ff68872493d64f37980c4c962902a9&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F68%2F59%2F71X58PICNjx_1024.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554805718205&di=466960a1e2dd6eba4b89573e875091b4&imgtype=0&src=http%3A%2F%2Fpic1.nipic.com%2F2008-08-14%2F2008814183939909_2.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554805809813&di=f50acb8d0085c25907e9cfe04415d2fe&imgtype=0&src=http%3A%2F%2Fpic15.nipic.com%2F20110628%2F1369025_192645024000_2.jpg","" +
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554805811046&di=6e5f8472ba26fa8fea529c6629707514&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F9%2F5450ae2fdef8a.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554805855083&di=906583221a0aa768dbb6caff9106e535&imgtype=0&src=http%3A%2F%2Fpic37.nipic.com%2F20140110%2F17563091_221827492154_2.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1554805855719&di=aa3596366852179e2a301eb794f070b4&imgtype=0&src=http%3A%2F%2Fimg1.ph.126.net%2FSSvFbcJzwGBlqy4xon6FjA%3D%3D%2F6608832342050415367.jpg"};
    private JLabel jLabel;
    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;

    }
    @Override
    public void run() {
        int i = 0;
        int length = s.length;
        while (true) {
            try {
                URL url = new URL(s[i]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5 * 1000);
                InputStream inputStream = conn.getInputStream();
                ByteArrayOutputStream out1 = new ByteArrayOutputStream();
                //准备缓冲字节流数组
                byte[] buffer = new byte[1024];
                int len = 0;
                //每次读入一个缓冲区大小的字节数
                while ((len = inputStream.read(buffer)) != -1) {
                    //将缓冲区内容写出
                    out1.write(buffer, 0, len);
                }
               byte[] data = out1.toByteArray();
                inputStream.read(data);
                Icon icon = new ImageIcon(data);
                jLabel.setIcon(icon);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == length){
                    i=0;
                }
            } catch (IOException e) {
                System.out.println("IO异常");
            }
        }
    }
}
