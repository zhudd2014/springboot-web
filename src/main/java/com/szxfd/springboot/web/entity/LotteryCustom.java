/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryCustom
 * Author:   admin
 * Date:     2019/3/21 23:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/21
 * @since 1.0.0
 */
public class LotteryCustom extends Lottery {

    /**
     * 奖项、中奖人封装
     */
    private Award awardBean;
    /**
     * 该活动的所有参与者
     */
    private List<UserCustom> userCustoms;

    public Award getAwardBean() {
        return awardBean;
    }

    public void setAwardBean(Award awardBean) {
        this.awardBean = awardBean;
    }

    public List<UserCustom> getUserCustoms() {
        return userCustoms;
    }

    public void setUserCustoms(List<UserCustom> userCustoms) {
        this.userCustoms = userCustoms;
    }
}