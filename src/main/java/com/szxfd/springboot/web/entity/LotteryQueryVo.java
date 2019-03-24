/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryQueryVo
 * Author:   admin
 * Date:     2019/3/21 23:47
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
public class LotteryQueryVo {

    /**
     * 奖品id
     */
    private List<Integer> ids;

    /**
     * 奖品信息
     */
    private LotteryCustom lotteryCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public LotteryCustom getLotteryCustom() {
        return lotteryCustom;
    }

    public void setLotteryCustom(LotteryCustom lotteryCustom) {
        this.lotteryCustom = lotteryCustom;
    }

    @Override
    public String toString() {
        return "LotteryQueryVo{" +
                "ids=" + ids +
                ", lotteryCustom=" + lotteryCustom +
                '}';
    }
}