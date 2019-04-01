package com.soft1841.io;

import java.io.File;
import java.io.IOException;

/**
 * File基础操作1
 * @author 位哲武
 * 2019.3.25
 */

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/README.md");
        //判定如果file不存在，则创建新文件
        if (!file.exists()){
            file.createNewFile();
        }
    }
}
