/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryTask
 * Author:   admin
 * Date:     2019/3/31 18:09
 * Description: 开奖任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.listener;

import com.szxfd.springboot.web.dao.LotteryMapper;
import com.szxfd.springboot.web.entity.LotteryStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 〈一句话功能简述〉<br>
 * 〈开奖任务〉
 *
 * @author admin
 * @create 2019/3/31
 * @since 1.0.0
 */
@Component
public class LotteryTask {

    @Resource
    private LotteryMapper lotteryMapper;
    private Timer timer = new Timer();

    /**
     * 在指定时间开奖
     *
     * @param date
     */
    public void start(Date date) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                lotteryMapper.setStatus(LotteryStatus.HAS_PUBLISH.getCode());
            }
        }, date);
    }

}