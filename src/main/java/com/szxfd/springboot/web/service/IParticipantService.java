/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IParticipantService
 * Author:   admin
 * Date:     2019/3/24 16:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.service;

import com.szxfd.springboot.web.entity.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/24
 * @since 1.0.0
 */
public interface IParticipantService {

    /**
     * 参与活动
     *
     * @param participantCustom
     * @return
     */
    BaseResponse<Boolean> join(ParticipantCustom participantCustom);

    /**
     * 退出活动
     *
     * @param participantCustom
     * @return
     */
    BaseResponse<Boolean> exit(ParticipantCustom participantCustom);

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


    List<Participant> queryParticipants(int id);

    List<Participant> setParticipants(List<Integer> ids);
}