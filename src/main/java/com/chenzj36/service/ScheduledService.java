package com.chenzj36.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author Danny Lyons
 * @Email chenzj36@live.cn
 * @Time 2020/2/10 13:37
 * @Description
 */
@Service
public class ScheduledService {
    @Scheduled(cron = "0/2 * * * * ?")
    public void hello(){
        System.out.println("定时任务执行~~~");
    }
}
