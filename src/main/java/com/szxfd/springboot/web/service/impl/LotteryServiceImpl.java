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

import com.szxfd.springboot.web.dao.LotteryMapper;
import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.Lottery;
import com.szxfd.springboot.web.entity.LotteryCustom;
import com.szxfd.springboot.web.entity.LotteryQueryVo;
import com.szxfd.springboot.web.manager.ILotteryManager;
import com.szxfd.springboot.web.service.ILotteryService;
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
public class LotteryServiceImpl implements ILotteryService {

    @Autowired
    private ILotteryManager lotteryManager;

    @Resource
    private LotteryMapper lotteryMapper;

    @Override
    public BaseResponse<Integer> create(LotteryCustom lotteryCustom) {
        return lotteryManager.create(lotteryCustom);
    }

    @Override
    public BaseResponse<Boolean> updateById(LotteryCustom lotteryCustom) {
        return lotteryManager.updateById(lotteryCustom);
    }

    @Override
    public BaseResponse<Boolean> deleteById(LotteryCustom lotteryCustom) {
        if (null == lotteryCustom) {
            BaseResponse<Boolean> response = new BaseResponse<>();
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        int id = lotteryCustom.getId();
        return lotteryManager.deleteById(id);
    }

    @Override
    public BaseResponse<LotteryCustom> queryById(LotteryCustom lotteryCustom) {
        if (null == lotteryCustom) {
            BaseResponse<LotteryCustom> response = new BaseResponse<>();
            response.setSuccess(false);
            response.setErrorMsg("lotteryCustom is null");
            return response;
        }
        int id = lotteryCustom.getId();
        return lotteryManager.queryById(id);
    }

    @Override
    public BaseResponse<List<LotteryCustom>> queryList(LotteryQueryVo lotteryQueryVo) {
        return lotteryManager.queryList(lotteryQueryVo);
    }

    @Override
    public BaseResponse<Integer> queryLotteryCount(LotteryQueryVo lotteryQueryVo) {
        return lotteryManager.queryLotteryCount(lotteryQueryVo);
    }

    @Override
    public BaseResponse<Boolean> updateAwardsAndWinners(LotteryCustom lotteryCustom) {
        return lotteryManager.updateAwardsAndWinners(lotteryCustom);
    }

    @Override
    public List<Lottery> queryLotteryList() {
        return lotteryMapper.getLotteryList();
    }

    @Override
    public int insertLottery(Lottery lottery) {
        return lotteryMapper.insertLottery(lottery);
    }

    @Override
    public int updateLottery(Lottery lottery) {
        return 0;
    }

    @Override
    public int deleteLottery(int id) {
        return 0;
    }

    @Override
    public BaseResponse<LotteryCustom> queryLotteryAndUsersByLotteryId(LotteryCustom lotteryCustom) {
        return lotteryManager.queryLotteryAndUsersByLotteryId(lotteryCustom);
    }

    @Override
    public BaseResponse<Boolean> setOpenType(LotteryCustom lotteryCustom) {
        return lotteryManager.setOpenType(lotteryCustom);
    }

}