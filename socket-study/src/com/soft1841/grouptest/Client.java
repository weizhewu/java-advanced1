package com.soft1841.grouptest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private JButton startBtn;
    private JButton confirmBtn;
    private JPanel topPanel;
    private Socket socket;
    private String info;
    public static void main(String[] args) throws IOException {
        new Client();
    }

    public Client() throws IOException {
        init();
        setLocationRelativeTo(null);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
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
        startBtn = new JButton("启动客户端");
        add(startBtn,BorderLayout.SOUTH);
        startBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            socket = new Socket("192.168.43.73",10086);
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        if (e.getSource() == startBtn) {
            System.out.println("服务器已连接");
            ReceiveThread1 rt1 = new ReceiveThread1(socket);
            new Thread(rt1).start();
        }
        if (e.getSource() == confirmBtn) {
            info = "12121";
            GiveThread1 gt1 = new GiveThread1(socket);
            new Thread(gt1).start();
        }
    }
}
class ReceiveThread1 implements Runnable{
    private Socket socket;
    private JTextArea textArea;

    public ReceiveThread1(JTextArea textArea) {
        this.textArea = textArea;
    }
    public ReceiveThread1(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream in = null;
        try {
            in = socket.getInputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println(new String(b));
            textArea.setText(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class GiveThread1  implements Runnable{
    private Socket socket;
    private JTextField textField;
    private String info;

    public GiveThread1(String info) {
        this.info = info;
    }

    public GiveThread1(JTextField textField) {
        this.textField = textField;
    }
    public GiveThread1(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
            out.write(info.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
