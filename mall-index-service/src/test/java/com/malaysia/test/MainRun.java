package com.malaysia.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/6.
 */
public class MainRun {
    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring/application-context.xml");
        context.start();// 服务开启
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
