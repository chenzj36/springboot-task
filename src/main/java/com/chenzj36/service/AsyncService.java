package com.chenzj36.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/2/9 14:47
 * @Description
 */
@Service
public class AsyncService {

    @Async
    public String hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理完成......");
        return "OK";
    }
}
