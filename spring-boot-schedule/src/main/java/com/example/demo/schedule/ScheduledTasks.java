package com.example.demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 此类九行代码快速实现一个定时器
 *
 * @author LiXiang
 * @date 2020/6/8 16:38
 */
@Component
@Slf4j
public class ScheduledTasks {
    //@Scheduled(fixedRate = 5000)
    @Scheduled(fixedRate = 10000)
    public void ScheduledTasks() {
        int offset = 0;
        int limit = 5;
        log.info("ScheduledTasks stat{}", new Date());

        log.info("The time is now {}", new Date());
    }
}
