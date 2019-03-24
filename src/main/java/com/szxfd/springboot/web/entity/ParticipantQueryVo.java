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
public class ParticipantQueryVo {

    /**
     * 参与id
     */
    private List<Integer> ids;

    /**
     * 奖品信息
     */
    private ParticipantCustom participantCustom;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public ParticipantCustom getParticipantCustom() {
        return participantCustom;
    }

    public void setParticipantCustom(ParticipantCustom participantCustom) {
        this.participantCustom = participantCustom;
    }

    @Override
    public String toString() {
        return "ParticipantQueryVo{" +
                "ids=" + ids +
                ", participantCustom=" + participantCustom +
                '}';
    }
}