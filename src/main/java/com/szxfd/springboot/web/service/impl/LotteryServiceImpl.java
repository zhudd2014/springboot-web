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
import com.szxfd.springboot.web.dao.ParticipantMapper;
import com.szxfd.springboot.web.entity.*;
import com.szxfd.springboot.web.manager.ILotteryManager;
import com.szxfd.springboot.web.service.ILotteryService;
import com.szxfd.springboot.web.utils.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Resource
    private ParticipantMapper participantMapper;

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
    public Lottery getLotteryById(int id) {
        return lotteryMapper.getLotteryById(id);
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
    public int setLottery(int id) {
        Lottery lottery = lotteryMapper.getLotteryById(id);
        if (lottery.getStatus() == 1) {
            return 0;
        }
        //所有的参与者
        List<Participant> participants = participantMapper.queryParticipants(id);
        List<Prize> prizeList = FastJsonUtils.getJsonToList(lottery.getAward(), Prize.class);
        List<ArrayList<Participant>> participantList = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            participantList.add(new ArrayList<>());
        }
        for (Participant participant : participants) {
            if (participant.getPrize_level() == 0) {
                participantList.get(0).add(participant);
            } else if (participant.getPrize_level() == 1) {
                participantList.get(1).add(participant);
            } else if (participant.getPrize_level() == 2) {
                participantList.get(2).add(participant);
            } else if (participant.getPrize_level() == 3) {
                participantList.get(3).add(participant);
            } else if (participant.getPrize_level() == 4) {
                participantList.get(4).add(participant);
            } else if (participant.getPrize_level() == 5) {
                participantList.get(5).add(participant);
            }
        }
        for (int i = 0; i < prizeList.size(); i++) {
            if (prizeList.get(i).getQuantity() > participantList.get(i + 1).size()) {
                int levelSize = prizeList.get(i).getQuantity() - participantList.get(i + 1).size();
//                participantList.get(0) = setPrize(i + 1, levelSize, participantList.get(0));
                participantList.set(0, setPrize(i + 1, levelSize, participantList.get(0)));
            }
        }
        lottery.setStatus(1);
        lotteryMapper.updateLottery(lottery);
        return 0;
    }

    /**
     * 奖品设置
     *
     * @param level        等级
     * @param levelSize    需要随机设置人数
     * @param participants 未中奖的参与者
     * @return
     */
    private ArrayList<Participant> setPrize(int level, int levelSize, ArrayList<Participant> participants) {
        List<Integer> levelList = getRandom(levelSize, participants.size());
        List<Integer> ids = new ArrayList<>();
        ParticipantPrize participantPrize = new ParticipantPrize();
        for (int i = 0; i < levelSize; i++) {
            ids.add(participants.get(levelList.get(i)).getId());
        }
        participantPrize.setPrize_level(level);
        participantPrize.setIds(ids);
        participantMapper.setParticipants(participantPrize);
        for (int i = 0; i < levelSize; i++) {
            participants.remove(participants.get(levelList.get(i)));
        }
        return participants;
    }

    /**
     * 获取非重复随机数
     *
     * @param size
     * @param max
     * @return
     */
    public List<Integer> getRandom(int size, int max) {
        List<Integer> lst = new ArrayList<>();//存放有序数字集合
        List<Integer> ids = new ArrayList<>();//存放结果
        for (int i = 0; i < max; i++) {
            lst.add(i);
        }
        int index = 0;
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            index = rd.nextInt(max - 1);
            lst.remove((Integer) index);
            ids.add(index);
        }
        return ids;
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