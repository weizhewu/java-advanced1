package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupFrame extends JFrame implements ActionListener {
    private JButton top1,top2,top3,top4,top5;
    public GroupFrame(){
        init();
        setTitle("记事本");
        setSize(new Dimension(1024,768));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init(){

    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e){
    }
}
