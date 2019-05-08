package com.soft1841.thread.Demo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupDemo {
    public static void main(String[] args)throws Exception {
        //1.指定目标链接
        String url = "https://www.jianshu.com/";
        //2.建立与目标页面的链接
        Connection connection = Jsoup.connect(url);
        //3.解析目标页面
        Document document =connection.get();
        //获取页面中所有的class为collection-article-intro的元素 检查元素
        Elements elements = document.getElementsByClass("content");
        System.out.println(elements.size());
        for (Element element:elements) {
           Element link = element.child(0);
            //得到a标记的文字内容
            String titleString = link.text();
            System.out.println(titleString);
        }
    }
}
