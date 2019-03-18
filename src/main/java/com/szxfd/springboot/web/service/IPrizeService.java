package com.szxfd.springboot.web.service;

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.PrizeCustom;
import com.szxfd.springboot.web.entity.PrizeQueryVo;

import java.util.List;

public interface IPrizeService {

    BaseResponse add(PrizeCustom prizeCustom);

    boolean remove(int id);

    boolean update(PrizeCustom prizeCustom);

    BaseResponse<PrizeCustom> queryById(int id);

    BaseResponse<List<PrizeCustom>> queryByTitle(String title);

    List<PrizeCustom> queryList(PrizeQueryVo prizeQueryVo);
}
