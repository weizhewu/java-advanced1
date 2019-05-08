package com.soft1841.grouptest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFrame extends JFrame implements ActionListener {
    private JButton startButton;
    private JTextArea contentArea;
    public ServerFrame(){
        init();
        setLocationRelativeTo(null);
        setSize(1000,900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        startButton = new JButton("启动");
        startButton.addActionListener(this);
        add(startButton,BorderLayout.NORTH);
        contentArea = new JTextArea();
        add(contentArea, BorderLayout.CENTER);
    }

    public static void main(String[] args) throws IOException {
        new ServerFrame();
        System.out.println("ts");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  startButton){
            System.out.println("启动成功");
            try {
                ServerSocket serverSocket = new ServerSocket(10086);

                while (true){
                    Socket socket = serverSocket.accept();
                    ServerThread serverThread = new ServerThread(socket);
                    new Thread(serverThread).start();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
class ServerThread extends Thread{
    private Socket socket;
    private JTextArea contentArea;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public ServerThread(JTextArea contentArea) {
        this.contentArea = contentArea;
    }

    @Override
    public void run() {
        while (true){
            try {
                InputStream in = socket.getInputStream();
                byte[] b = new byte[1024];
                in.read(b);
                contentArea = new JTextArea();
                contentArea.setText("客户端"+socket.getInetAddress()+"发送的数据是："+new String(b));
                OutputStream out = socket.getOutputStream();
                contentArea.setText("请输入要发给服务器的内容:");
                String info  = contentArea.getText();
                out.write(info.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}