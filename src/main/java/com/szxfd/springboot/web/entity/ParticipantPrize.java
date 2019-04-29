/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Participant
 * Author:   admin
 * Date:     2019/3/10 21:27
 * Description: 活动参与人列表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.entity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈活动参与人列表〉
 *
 * @author admin
 * @create 2019/3/10
 * @since 1.0.0
 */
public class ParticipantPrize {

    private List<Integer> ids;
    private Integer prize_level;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Integer getPrize_level() {
        return prize_level;
    }

    public void setPrize_level(Integer prize_level) {
        this.prize_level = prize_level;
    }

    @Override
    public String toString() {
        return "ParticipantPrize{" +
                "ids=" + ids +
                ", prize_level=" + prize_level +
                '}';
    }
}