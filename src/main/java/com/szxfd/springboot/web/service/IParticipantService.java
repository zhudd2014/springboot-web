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

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.ParticipantCustom;
import com.szxfd.springboot.web.entity.ParticipantQueryVo;

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

    BaseResponse<Integer> insert(ParticipantCustom participantCustom);

    BaseResponse<Boolean> deleteById(ParticipantCustom participantCustom);

    BaseResponse<List<ParticipantCustom>> queryParticipantList(ParticipantQueryVo participantQueryVo);

    BaseResponse<Integer> queryParticipantCount(ParticipantQueryVo participantQueryVo);

}