package com.soft1841.gui;

import javax.swing.*;

public class BlizzardBattleNetworkFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JLabel left1Label;
    private JLabel left2Label;
    private JLabel left3Label;
    private JLabel left4Label;
    private JLabel left5Label;
    private JLabel left6Label;
    private JLabel left7Label;
    private JLabel left8Label;
    private JPanel top1Panel;
    private JLabel top1Label;
    private JPanel topPanel;
    private JPanel top2Panel;
    private JLabel centerLabel;
    private JPanel centerPanel;


    public static void main(String[] args) throws Exception{
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("BlizzardBattleNetworkFrame");
        frame.setContentPane(new BlizzardBattleNetworkFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
