package com.szxfd.springboot.web.service;

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.PrizeCustom;
import com.szxfd.springboot.web.entity.PrizeQueryVo;

import java.util.List;

public interface IPrizeService {

    BaseResponse<Integer> insert(PrizeCustom prizeCustom);

    BaseResponse<Boolean> removeInLogical(PrizeCustom prizeCustom);

    BaseResponse<Boolean> update(PrizeCustom prizeCustom);

    BaseResponse<PrizeCustom> queryPrizeById(PrizeCustom prizeCustom);

    BaseResponse<List<PrizeCustom>> queryPrizeByTitle(String title);

    BaseResponse<List<PrizeCustom>> queryPrizeList(PrizeQueryVo prizeQueryVo);

    BaseResponse<Integer> queryPrizeCount(PrizeQueryVo prizeQueryVo);
}
