package com.soft1841.thread.group1;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 播放本地音乐
 */
public class RandomPointThread extends Thread {
    @Override
    public void run() {
        File file = new File("D:/yy/1.wav");
        URL url ;
        try {
            url = file.toURI().toURL();
            AudioClip audioClip = Applet.newAudioClip(url);
            audioClip.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
