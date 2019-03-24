/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserCustom
 * Author:   admin
 * Date:     2019/3/7 23:40
 * Description: 用户拓展类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户拓展类〉
 *
 * @author admin
 * @create 2019/3/7
 * @since 1.0.0
 */
public class UserCustom extends User {

    //可以在User基础上拓展一些属性
    /**
     * 该user参加的所有活动
     */
    private List<LotteryCustom> lotteryCustoms;

    public List<LotteryCustom> getLotteryCustoms() {
        return lotteryCustoms;
    }

    public void setLotteryCustoms(List<LotteryCustom> lotteryCustoms) {
        this.lotteryCustoms = lotteryCustoms;
    }
}