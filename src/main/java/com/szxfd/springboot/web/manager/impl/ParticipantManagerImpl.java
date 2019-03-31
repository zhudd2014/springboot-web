/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ParticipantManageImpl
 * Author:   admin
 * Date:     2019/3/31 18:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.manager.impl;

import com.szxfd.springboot.web.dao.ParticipantMapper;
import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.ParticipantCustom;
import com.szxfd.springboot.web.entity.ParticipantQueryVo;
import com.szxfd.springboot.web.manager.IParticipantManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/31
 * @since 1.0.0
 */
@Component
public class ParticipantManagerImpl implements IParticipantManager {

    @Resource
    private ParticipantMapper participantMapper;

    @Override
    public BaseResponse<Integer> insert(ParticipantCustom participantCustom) {
        BaseResponse<Integer> response = new BaseResponse();
        if (null == participantCustom) {
            response.setSuccess(false);
            response.setErrorMsg("participantCustom is null");
            return response;
        }
        int insert = participantMapper.insert(participantCustom);
        if (insert > 0) {
            response.setSuccess(true);
            response.setObj(participantCustom.getId());
        } else {
            response.setSuccess(false);
            response.setErrorMsg("insert data fail in database");
        }
        return response;
    }

    @Override
    public BaseResponse<Boolean> deleteById(ParticipantCustom participantCustom) {
        BaseResponse<Boolean> response = new BaseResponse();
        if (null == participantCustom) {
            response.setSuccess(false);
            response.setErrorMsg("participantCustom is null");
            return response;
        }
        int remove = participantMapper.removeInLogical(participantCustom.getId());
        if (remove > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("delete data fail in database");
        }
        return response;
    }

    @Override
    public BaseResponse<List<ParticipantCustom>> queryParticipantList(ParticipantQueryVo participantQueryVo) {
        BaseResponse<List<ParticipantCustom>> response = new BaseResponse();
        List<ParticipantCustom> participantCustoms = participantMapper.queryParticipantList(participantQueryVo);
        response.setSuccess(true);
        response.setObj(participantCustoms);
        return response;
    }

    @Override
    public BaseResponse<Integer> queryParticipantCount(ParticipantQueryVo participantQueryVo) {
        BaseResponse<Integer> response = new BaseResponse<>();
        int count = participantMapper.queryParticipantCount(participantQueryVo);
        response.setSuccess(true);
        response.setObj(count);
        return response;
    }

    @Override
    public int queryParticipantCount(int lotteryId) {
        ParticipantCustom custom = new ParticipantCustom();
        custom.setLottery_id(lotteryId);
        ParticipantQueryVo queryVo = new ParticipantQueryVo();
        queryVo.setParticipantCustom(custom);
        int count = participantMapper.queryParticipantCount(queryVo);
        return count;
    }
}