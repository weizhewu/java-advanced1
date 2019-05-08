package com.soft1841.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public  class Server3 {
    public static void main(String[] args)throws IOException {
        ServerSocket serversocket= new ServerSocket(2323);
        System.out.println("服务器启动");
        while(true){
            Socket socket =serversocket.accept();
            Serverthread1 server= new Serverthread1(socket);
            new Thread(server).start();
        }
    }
}
class Serverthread1 implements Runnable {
    private Socket socket;

    public Serverthread1(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        System.out.println("客户端"+ socket.getInetAddress()+"连接成功!");
        InputStream inputstream=null;
            try {
                inputstream =socket.getInputStream();
                BufferedReader br =new BufferedReader(new InputStreamReader(inputstream));
                System.out. println(br.readLine());
                br.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

