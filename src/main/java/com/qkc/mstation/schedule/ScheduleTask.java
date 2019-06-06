package com.qkc.mstation.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by qukoucai001 on 2018/12/4.
 */

@Component
@Configurable
@EnableScheduling
public class ScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);



//    @Scheduled(fixedRate = 10*1000)
    public void myScheduled(){
        logger.info("ScheddfgdfuleTask:"+new Date());
   }
}
