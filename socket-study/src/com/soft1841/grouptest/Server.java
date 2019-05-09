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
    private Socket socket;


    public static void main(String[] args) throws IOException {
        new Server();
    }

    public Server() {
        init();
        setLocationRelativeTo(null);
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        topPanel = new JPanel();
        confirmBtn = new JButton("发送");
        confirmBtn.setPreferredSize(new Dimension(120, 40));
        confirmBtn.addActionListener(this);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 40));
        topPanel.add(textField);
        topPanel.add(confirmBtn);
        add(topPanel, BorderLayout.NORTH);
        textArea = new JTextArea();
        //文本域设置成不可编辑
        textArea.setEditable(false);
        //文本域设置成不可获得焦点
        textArea.setFocusable(false);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane,BorderLayout.CENTER);
        startBtn = new JButton("启动服务器");
        add(startBtn, BorderLayout.SOUTH);
        startBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            startServer();
            startBtn.setVisible(false);
        }
        if (e.getSource() == confirmBtn) {
            OutputStream out = null;
            try {
                out = socket.getOutputStream();
                info="李家劲："+textField.getText();
                out.write(info.getBytes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
    private void startServer(){
        try {
            ServerSocket ss = new ServerSocket(10086);
            socket = ss.accept();
            System.out.println("服务器"+socket.getLocalSocketAddress()+"已启动");

            read();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    private void read(){
        System.out.println("客户端——"+socket.getInetAddress() + "——已登录");
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream in = null;
                try {
                   while (true){
                       in = socket.getInputStream();
                       byte[] b = new byte[1024];
                       in.read(b);
                       textArea.append(new String(b)+"\n");
                   }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
