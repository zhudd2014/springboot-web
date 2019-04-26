/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrizeService
 * Author:   admin
 * Date:     2019/3/17 23:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.service.impl;

import com.szxfd.springboot.web.dao.PrizeMapper;
import com.szxfd.springboot.web.entity.Prize;
import com.szxfd.springboot.web.service.IPrizeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/17
 * @since 1.0.0
 */
@Service
public class PrizeServiceImpl implements IPrizeService {

    @Resource
    private PrizeMapper prizeMapper;

    @Override
    public List<Prize> queryPrizes() {
        return prizeMapper.queryPrizes();
    }

    @Override
    public int insert(Prize prize) {
        return prizeMapper.insertPrize(prize);
    }

    @Override
    public int update(Prize prize) {
        return prizeMapper.updatePrize(prize);
    }

    @Override
    public int deletePrize(int id) {
        return prizeMapper.deletePrize(id);
    }

}