package com.soft1841.fifthDay;

public class LoggerFileSystem implements Logger {
    @Override
    public void log(String message) {
        System.out.println("日志输出到本地文件系统"+message);
    }
}
