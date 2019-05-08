package com.soft1841.grouptest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private JButton startBtn;
    private JButton confirmBtn;
    private JPanel topPanel;
    private String info;

    public static void main(String[] args) throws IOException {
        new Server();
    }
    public Server() throws IOException {
        init();
        setLocationRelativeTo(null);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        topPanel = new JPanel();
        confirmBtn = new JButton("发送");
        confirmBtn.setPreferredSize(new Dimension(120,40));
        confirmBtn.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300,40));
        topPanel.add(textField);
        topPanel.add(confirmBtn);
        add(topPanel,BorderLayout.NORTH);
        textArea = new JTextArea();
        add(textArea,BorderLayout.CENTER);
        startBtn = new JButton("启动服务器");
        add(startBtn,BorderLayout.SOUTH);
        startBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(10086);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        if (e.getSource()==startBtn){
            System.out.println("服务器已登录");
            while (true){
                try {
                    Socket socket = ss.accept();
                    ReceiveThread rt = new ReceiveThread(socket);
                    new Thread(rt).start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (e.getSource()==confirmBtn){
            info = textField.getText().trim();

            while (true){
                try {
                    Socket socket = ss.accept();
                    GiveThread gt =  new GiveThread(socket);
                    new Thread(gt).start();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
class ReceiveThread implements Runnable{
    private Socket socket;

    public ReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"连接成功");
        try {
            InputStream in = socket.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
class GiveThread implements Runnable{
    private Socket socket;
    private String info;

    public GiveThread(String info) {
        this.info = info;
    }


    public GiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
            PrintStream printStream = new PrintStream(out);
            printStream.println(info);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
