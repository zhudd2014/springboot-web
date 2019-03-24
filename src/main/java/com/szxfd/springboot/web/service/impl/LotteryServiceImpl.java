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
package com.szxfd.springboot.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.szxfd.springboot.web.dao.LotteryMapper;
import com.szxfd.springboot.web.entity.Award;
import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.LotteryCustom;
import com.szxfd.springboot.web.entity.LotteryQueryVo;
import com.szxfd.springboot.web.service.ILotteryService;
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
public class LotteryServiceImpl implements ILotteryService {

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
    public BaseResponse<Boolean> deleteById(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        int result = lotteryMapper.deleteById(lotteryCustom.getId());
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
    public BaseResponse<LotteryCustom> queryById(LotteryCustom lotteryCustom) {
        BaseResponse<LotteryCustom> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        LotteryCustom lotteryCustomQuery = lotteryMapper.queryById(lotteryCustom.getId());
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
    public BaseResponse<Boolean> updateLotteryWay(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        int result = lotteryMapper.updateLotteryWay(lotteryCustom);
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
    public BaseResponse<Boolean> updateAwardsAndWinners(LotteryCustom lotteryCustom) {
        BaseResponse<Boolean> response = new BaseResponse<>();
        if (null == lotteryCustom) {
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
//        if (checkAwardsAndWinners(lotteryCustom)) {
//            response.setSuccess(false);
//            response.setErrorMsg("award format error");
//            return response;
//        }
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
}