package com.soft1841.thread.group1;

import javax.swing.*;

public class MusicPlayerThread extends Thread {
    private String[] music ={"https://y.qq.com/n/yqq/song/001J5QJL1pRQYB.html",
            "https://y.qq.com/portal/search.html#page=1&searchid=1&remoteplace=txt.yqq.top&t=song&w=%E4%BD%A0%E7%9A%84%E9%85%92%E9%A6%86%E5%AF%B9%E6%88%91%E6%89%93%E4%BA%86%E7%83%8A"};
    private JComboBox musicCoboBox;

    public void setMusicCoboBox(JComboBox musicCoboBox) {
        this.musicCoboBox = musicCoboBox;
    }

    @Override
    public void run() {

    }
}
