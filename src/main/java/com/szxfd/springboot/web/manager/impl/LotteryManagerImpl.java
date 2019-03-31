/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LotteryServiceImpl
 * Author:   admin
 * Date:     2019/3/24 14:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.szxfd.springboot.web.dao.LotteryMapper;
import com.szxfd.springboot.web.entity.*;
import com.szxfd.springboot.web.manager.ILotteryManager;
import com.szxfd.springboot.web.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
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
public class LotteryManagerImpl implements ILotteryManager {

    @Resource
    private LotteryMapper lotteryMapper;

    @Override
    public BaseResponse<Integer> create(LotteryCustom lotteryCustom) {
        BaseResponse<Integer> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        int result = lotteryMapper.insert(lotteryCustom);
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(lotteryCustom.getId());
        } else {
            response.setSuccess(false);
            response.setErrorMsg("insert lottery fail");
        }
        return response;
    }

    @Override
    public BaseResponse<Boolean> updateById(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        int result = lotteryMapper.updateById(lotteryCustom);
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("update lottery fail");
        }
        return response;
    }

    @Override
    public BaseResponse<Boolean> deleteById(int id) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        int result = lotteryMapper.deleteById(id);
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("delete lottery fail");
        }
        return response;
    }

    @Override
    public BaseResponse<LotteryCustom> queryById(int id) {
        BaseResponse<LotteryCustom> response = new BaseResponse<>();
        LotteryCustom lotteryCustomQuery = lotteryMapper.queryById(id);
        if (null == lotteryCustomQuery) {
            response.setSuccess(false);
            response.setErrorMsg("data not found in database");
        } else {
            response.setSuccess(true);
            response.setObj(lotteryCustomQuery);
        }
        return response;
    }

    @Override
    public BaseResponse<List<LotteryCustom>> queryList(LotteryQueryVo lotteryQueryVo) {
        BaseResponse<List<LotteryCustom>> response = new BaseResponse<>();
        List<LotteryCustom> lotteryCustoms = lotteryMapper.queryLotteryList(lotteryQueryVo);
        response.setSuccess(true);
        response.setObj(lotteryCustoms);
        return response;
    }

    @Override
    public BaseResponse<Integer> queryLotteryCount(LotteryQueryVo lotteryQueryVo) {
        BaseResponse<Integer> response = new BaseResponse<>();
        int count = lotteryMapper.queryLotteryCount(lotteryQueryVo);
        response.setSuccess(true);
        response.setObj(count);
        return response;
    }

    @Override
    public BaseResponse<Boolean> updateAwardsAndWinners(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }

        int id = lotteryCustom.getId();
        LotteryCustom lotteryCustomResp = lotteryMapper.queryById(id);
        if (lotteryCustomResp.getStatus() != LotteryStatus.WAIT_PUBLISH.getCode()) {
            response.setSuccess(false);
            response.setErrorMsg("目前不是待开奖状态，不允许设置");
            return response;
        }

        Award awardBean = lotteryCustom.getAwardBean();
        String award = JSON.toJSONString(awardBean);
        lotteryCustom.setAward(award);
        int result = lotteryMapper.updateAwardsAndWinners(lotteryCustom);
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("updateLotteryWay fail");
        }
        return response;
    }

    @Override
    public boolean setStatus(int status) {
        int result = lotteryMapper.setStatus(status);
        return result == 1;
    }

    private boolean checkAwardsAndWinners(LotteryCustom lotteryCustom) {
        if (null == lotteryCustom) {
            return false;
        }
        String awardStr = lotteryCustom.getAward();
        try {
            Award award = JSON.parseObject(awardStr, new TypeReference<Award>() {
            });
            // TODO: 2019/3/24 后续需要判断：只有设置了奖品才能设置中奖人
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public BaseResponse<LotteryCustom> queryLotteryAndUsersByLotteryId(LotteryCustom lotteryCustom) {
        BaseResponse<LotteryCustom> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        LotteryCustom lotteryCustomQuery = lotteryMapper.queryLotteryAndUsers(lotteryCustom.getId());
        response.setSuccess(true);
        response.setObj(lotteryCustomQuery);
        return response;
    }

    @Override
    public BaseResponse<Boolean> setOpenType(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }

        //查询当前状态，只有未开始时可以设置开奖方式
        LotteryCustom lotteryCustomStatus = lotteryMapper.queryById(lotteryCustom.getId());
        LotteryStatus status = LotteryStatus.code2Status(lotteryCustomStatus.getStatus());
        if (status == LotteryStatus.WAIT_PUBLISH || status == LotteryStatus.HAS_PUBLISH) {
            //活动已经开始，不能修改
            response.setSuccess(false);
            response.setErrorMsg("lottery has started, can not update");
            return response;
        }
        //开奖状态设置为未开始
        lotteryCustom.setStatus(LotteryStatus.NO_START.getCode());
        //开奖方式
        LotteryOpenType openType = LotteryOpenType.codeToType(lotteryCustom.getOpen_type());
        switch (openType) {
            case MANUAL:
                response = setManualOpenType(lotteryCustom);
                break;
            case SCHEDULED_TIME:
                response = setScheduledTimeOpenType(lotteryCustom);
                break;
            case SCHEDULED_QUANTITY:
                response = setScheduledQuantityOpenType(lotteryCustom);
                break;
            default:
                response.setSuccess(false);
                response.setErrorMsg(LotteryOpenType.NONE.getDesc());
                break;
        }
        return response;
    }

    private BaseResponse<Boolean> setScheduledQuantityOpenType(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        int openQuentity = lotteryCustom.getOpen_participator_num();
        if (openQuentity <= 0) {
            response.setSuccess(false);
            response.setObj(false);
            response.setErrorMsg("开奖人数必须大于0");
            return response;
        }
        lotteryCustom.setOpen_date("");
        int result = lotteryMapper.setOpenType(lotteryCustom);
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("not data found");
        }
        return response;
    }

    private BaseResponse<Boolean> setScheduledTimeOpenType(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        String openTime = lotteryCustom.getOpen_date();
        try {
            Date time = DateUtils.getSimpleDataformat().parse(openTime);
            if (time.getTime() < DateUtils.getTimeAfterHours(1)) {
                response.setSuccess(false);
                response.setObj(false);
                response.setErrorMsg("请设置一个小时之后的时间");
                return response;
            }
            Timestamp timestamp = Timestamp.valueOf(openTime);
            lotteryCustom.setOpen_date_timestamp(timestamp);
            lotteryCustom.setOpen_participator_num(0);
            int result = lotteryMapper.setOpenType(lotteryCustom);
            if (result > 0) {
                response.setSuccess(true);
                response.setObj(true);
            } else {
                response.setSuccess(false);
                response.setErrorMsg("not data found");
            }
            return response;
        } catch (ParseException e) {
            e.printStackTrace();
            response.setSuccess(false);
            response.setObj(false);
            response.setErrorMsg(e.getMessage());
            return response;
        }
    }

    private BaseResponse<Boolean> setManualOpenType(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        lotteryCustom.setOpen_date("");
        lotteryCustom.setOpen_participator_num(0);
        int result = lotteryMapper.setOpenType(lotteryCustom);
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("not data found");
        }
        return response;
    }
}