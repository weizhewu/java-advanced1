package com.soft1841.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(2323);
        System.out.println("服务器启动成功");
        while (true){
            Socket socket = ss.accept();
            ServerThread serverThread = new ServerThread(socket);
            new Thread(serverThread).start();
        }
    }
}
class ServerThread implements Runnable{
   private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(socket.getInetAddress()+"连接成功");
    }
}