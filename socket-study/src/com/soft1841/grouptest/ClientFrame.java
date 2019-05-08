package com.soft1841.grouptest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientFrame extends JFrame implements ActionListener {
    private JButton startButton;
    private JTextArea contentArea;
    public ClientFrame(){
        init();
        setLocationRelativeTo(null);
        setSize(1000,900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        startButton = new JButton("启动");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.NORTH);
        contentArea = new JTextArea();
        add(contentArea, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  startButton){
            try {
                Socket socket = new Socket("127.0.0.1",10086);
                while (true){
                    ClientThread clientThread = new ClientThread(socket);
                    new Thread(clientThread).start();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ClientFrame();
    }
}
class ClientThread extends Thread{
    private Socket socket;
    private JTextArea contentArea;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public ClientThread(JTextArea contentArea) {
        this.contentArea = contentArea;
    }


    @Override
    public void run() {
        System.out.println();
        try {
            OutputStream out = socket.getOutputStream();
            while (true){
                contentArea = new JTextArea();
                contentArea.setText("请输入要发给服务器的内容:");
                String info  = contentArea.getText();
                out.write(info.getBytes());
                InputStream in = socket.getInputStream();
                byte[] b = new byte[1024];
                in.read(b);
                contentArea.setText("服务端发送的数据是："+new String(b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
