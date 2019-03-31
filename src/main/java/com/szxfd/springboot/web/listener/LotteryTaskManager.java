/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryTaskManager
 * Author:   admin
 * Date:     2019/3/31 20:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.listener;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/31
 * @since 1.0.0
 */
@Component
public class LotteryTaskManager {

    private Map<Integer, LotteryTask> taskMap;

    private LotteryTaskManager() {
    }

    public LotteryTask getTask(int lotteryId) {
        if (null == taskMap) {
            return null;
        }
        return taskMap.get(lotteryId);
    }


}