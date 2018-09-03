package com.roy.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    /**
     * cron : 秒 分 时 日 月 周几
     * 示例： 0 * * * * MON-FRI 周一到周五到整分钟启动
     *
     * 【0 0/5 14,18 * * ？】每天14点整和18点整， 每隔5分钟执行一次
     * 【0 15 10 ？ * 1-6】每个月点周一到周六10：15分执行一次
     * 【0 0 2 ？ * 6L】每个月到最后一个周六凌晨2点执行一次
     * 【0 0 2 LW * ？】每个月点最后一个工作日凌晨2点执行一次
     * 【0 0 2-4 ？ * 1#1】每个月点最后一个周一凌晨2点到4点期间，每个整点都执行一次
     */
    //计划任务
    @Scheduled(cron = "0 * * * * MON-FRI") //整分启动
    //@Scheduled(cron = "0-10 * * * * MON-FRI") 区间0 到10秒启动
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI") 0,1,2,3,4秒启动
    //@Scheduled(cron = "0/4 * * * * MON-FRI") 0秒开始，每4秒启动
    public void hello(){

        System.out.println("Hello");
    }
}
