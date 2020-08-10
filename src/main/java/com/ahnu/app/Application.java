package com.ahnu.app;

import com.ahnu.app.service.Task;

import java.io.IOException;

import static com.ahnu.app.service.Task.stop;

/**
 * 启动方法
 *
 * @author DamonCheng@ssw.com.au
 * @date 8/4/2020 3:42 PM
 */
public class Application {
    /**
     * 每天启动的小时数
     */
    private final static int HOUR = 6;
    /**
     * 每天启动的分钟数
     */
    private final static int MINUTE = 50;

    /**
     * 每天启动的秒数
     */
    private final static int SECOND = 0;
    /**
     * 时间间隔(一天)
     */
    private final static long PERIOD_DAY = 24L * 60L * 60L * 1000L;

    /**
     * 心跳包 1小时一跳
     */
    final static int HEART_BEAT = 1000 * 60 * 60 * 1;

    /**
     * 程序入口
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("----------------start-----------------");
        System.out.println("--------------------------------------");
        Task task = new Task();
        while (true) {
            task.start();
            stop(HEART_BEAT);
        }
    }


}
