package com.soft1841.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",2323);
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入要发给服务器的内容:");
            String info  = scanner.nextLine();
            out.write(info.getBytes());
            InputStream in = socket.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println("服务端发送的数据是："+new String(b));
        }
    }
}
