package com.soft1841.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2323);
        System.out.println("服务器启动");
        OutputStream out;
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        while (true){
            Socket socket = ss.accept();
            System.out.println(socket.getInetAddress()+"上线了");
            out = socket.getOutputStream();
            out.write(info.getBytes());
            out.close();
            socket.close();
        }
    }
}
