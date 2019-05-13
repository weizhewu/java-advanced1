package com.soft1841.io;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://translate.google.cn/#view=home&op=translate&sl=zh-CN&tl=en&text=%E6%9A%B4%E9%9B%AA%E6%88%98%E7%BD%91");
            System.out.println("URL为："+url.toString());
            System.out.println("协议为："+url.getProtocol());
            System.out.println("验证消息："+ url.getAuthority());
            System.out.println("文件名及请求参数："+url.getFile());
            System.out.println("主机名："+url.getHost());
            System.out.println("路径："+url.getPath());
            System.out.println("端口："+url.getPort());
            System.out.println("默认端口："+url.getDefaultPort());
            System.out.println("请求参数："+url.getQuery());
            System.out.println("定位位置："+url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
