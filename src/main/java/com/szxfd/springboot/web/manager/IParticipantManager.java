/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IParticipantManager
 * Author:   admin
 * Date:     2019/3/31 18:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.manager;

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.ParticipantCustom;
import com.szxfd.springboot.web.entity.ParticipantQueryVo;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/31
 * @since 1.0.0
 */
public interface IParticipantManager {

    /**
     * 参与活动
     *
     * @param participantCustom
     * @return
     */
    BaseResponse<Integer> insert(ParticipantCustom participantCustom);

    /**
     * 退出活动
     *
     * @param participantCustom
     * @return
     */
    BaseResponse<Boolean> deleteById(ParticipantCustom participantCustom);

    /**
     * 综合查询
     *
     * @param participantQueryVo
     * @return
     */
    BaseResponse<List<ParticipantCustom>> queryParticipantList(ParticipantQueryVo participantQueryVo);

    /**
     * 综合查询
     *
     * @param participantQueryVo
     * @return
     */
    BaseResponse<Integer> queryParticipantCount(ParticipantQueryVo participantQueryVo);

    /**
     * 查询参与指定活动的总人数
     *
     * @param lotteryId
     * @return
     */
    int queryParticipantCount(int lotteryId);
}