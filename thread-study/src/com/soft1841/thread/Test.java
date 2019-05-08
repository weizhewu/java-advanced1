package com.soft1841.thread;

public class Test {
    public static void main(String[] args) {
        CircleThread circle = new CircleThread();
       Thread circleThread = new Thread(circle);
       circleThread.start();
    }
}
