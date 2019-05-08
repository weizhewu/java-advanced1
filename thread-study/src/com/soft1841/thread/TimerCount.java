package com.soft1841.thread;

public class TimerCount extends Thread {
    @Override
    public void run() {
        for (int i =10;i>0;i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始倒数");
        Thread.sleep(1000);
        TimerCount timerCount = new TimerCount();
        timerCount.start();
        Thread.sleep(1000);



    }
}
