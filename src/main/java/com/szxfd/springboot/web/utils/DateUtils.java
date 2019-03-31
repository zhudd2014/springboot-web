/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DateUtils
 * Author:   admin
 * Date:     2019/3/31 17:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.utils;

import java.text.SimpleDateFormat;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/31
 * @since 1.0.0
 */
public class DateUtils {

    public static SimpleDateFormat getSimpleDataformat() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    /**
     * 几个小时后的时间
     *
     * @param hours
     * @return
     */
    public static long getTimeAfterHours(int hours) {
        long current = System.currentTimeMillis();
        return current + hours * 60 * 60 * 1000;
    }

}