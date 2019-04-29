/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ParticipantServiceImpl
 * Author:   admin
 * Date:     2019/3/24 16:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.service.impl;

import com.szxfd.springboot.web.dao.ParticipantMapper;
import com.szxfd.springboot.web.entity.*;
import com.szxfd.springboot.web.manager.ILotteryManager;
import com.szxfd.springboot.web.manager.IParticipantManager;
import com.szxfd.springboot.web.service.IParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/24
 * @since 1.0.0
 */
@Service
public class ParticipantServiceImpl implements IParticipantService {

    @Autowired
    private IParticipantManager participantManager;
    @Autowired
    private ILotteryManager lotteryManager;

    @Resource
    private ParticipantMapper participantMapper;

    @Override
    public BaseResponse<Boolean> join(ParticipantCustom participantCustom) {
        BaseResponse<Boolean> response = new BaseResponse();
        if (null == participantCustom) {
            response.setSuccess(false);
            response.setErrorMsg("participantCustom is null");
            return response;
        }
        int lotteryId = participantCustom.getLottery_id();
        //判断活动是否开始，或者是否已经结束
        BaseResponse<LotteryCustom> lotteryStatusResponse = lotteryManager.queryById(lotteryId);
        if (!lotteryStatusResponse.isSuccess()) {
            response.setSuccess(false);
            response.setErrorMsg(lotteryStatusResponse.getErrorMsg());
            return response;
        }
        LotteryStatus lotteryStatus = LotteryStatus.code2Status(lotteryStatusResponse.getObj().getStatus());
        if (lotteryStatus != LotteryStatus.WAIT_PUBLISH) {
            response.setSuccess(false);
            response.setErrorMsg("该活动目前不能参与");
            return response;
        }

        //开始参加活动
        BaseResponse<Integer> joinResponse = participantManager.insert(participantCustom);
        if (!joinResponse.isSuccess()) {
            response.setSuccess(false);
            response.setErrorMsg(joinResponse.getErrorMsg());
            return response;
        }

        //参加活动的人数
        int count = participantManager.queryParticipantCount(lotteryId);
        BaseResponse<LotteryCustom> lotteryCountResponse = lotteryManager.queryById(lotteryId);
        if (!lotteryCountResponse.isSuccess()) {
            response.setSuccess(false);
            response.setErrorMsg(lotteryCountResponse.getErrorMsg());
            return response;
        }

        //若是“按人数开奖”，且达到预定人数则开奖
        int scheduleCount = lotteryCountResponse.getObj().getOpen_participator_num();
        if (scheduleCount == count) {
            lotteryManager.setStatus(LotteryStatus.HAS_PUBLISH.getCode());
        }

        response.setSuccess(true);
        response.setObj(true);
        return response;
    }


    @Override
    public BaseResponse<Boolean> exit(ParticipantCustom participantCustom) {
        return null;
    }

    @Override
    public BaseResponse<List<ParticipantCustom>> queryParticipantList(ParticipantQueryVo participantQueryVo) {
        return null;
    }

    @Override
    public BaseResponse<Integer> queryParticipantCount(ParticipantQueryVo participantQueryVo) {
        return null;
    }

    @Override
    public List<Participant> queryParticipants() {
        return participantMapper.queryAllParticipants();
    }

    @Override
    public List<Participant> queryParticipants(int id) {
        return participantMapper.queryParticipants(id);
    }

    @Override
    public Integer setParticipants(ParticipantPrize participantPrize) {
        return participantMapper.setParticipants(participantPrize);
    }
}