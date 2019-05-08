package com.soft1841.socket;
import java.io.*;
import java.net.Socket;

public class Client5 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.43.89", 10086);
        System.out.println("成功连接到服务器...");
        //客户端需要发送的文件，先通过字节输入流读入字节数组b
        File file = new File("E:/1.jpg");
        byte[] b = new byte[(int) file.length()];
        InputStream is = new FileInputStream(file);
        is.read(b);
        //将数组b 通过缓冲字节
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        bos.write(b);
        bos.close();
        is.close();
    }
}