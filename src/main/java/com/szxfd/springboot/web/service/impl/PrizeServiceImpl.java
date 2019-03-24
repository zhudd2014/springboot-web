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
import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.PrizeCustom;
import com.szxfd.springboot.web.entity.PrizeQueryVo;
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
    public BaseResponse<Integer> insert(PrizeCustom prizeCustom) {
        BaseResponse response = new BaseResponse();
        if (null == prizeCustom) {
            response.setSuccess(false);
            response.setErrorMsg("prizeCustom为空");
            return response;
        }
        if (null == prizeCustom.getTitle() || "" == prizeCustom.getTitle()) {
            response.setSuccess(false);
            response.setErrorMsg("title为空");
            return response;
        }
        if (null == prizeCustom.getDesc() || "" == prizeCustom.getDesc()) {
            response.setSuccess(false);
            response.setErrorMsg("desc");
            return response;
        }
        if (prizeCustom.getPrice() < 0) {
            response.setSuccess(false);
            response.setErrorMsg("price不能为负数");
            return response;
        }
        if (prizeCustom.getQuantity() < 0) {
            response.setSuccess(false);
            response.setErrorMsg("quantity不能为负数");
            return response;
        }
        //先查询奖品是否已经存在
        int result = prizeMapper.insert(prizeCustom);
        if (result >= 0) {
            response.setSuccess(true);
            response.setObj(prizeCustom.getId());
        } else {
            response.setSuccess(false);
            response.setErrorMsg("插入数据库失败");
        }
        return response;
    }

    @Override
    public BaseResponse<Boolean> removeInLogical(PrizeCustom prizeCustom) {
        BaseResponse<Boolean> response = new BaseResponse();
        if (null == prizeCustom) {
            response.setSuccess(false);
            response.setErrorMsg("prizeCusom is null");
            return response;
        }
        //先查询奖品是否已经存在
        PrizeCustom prizeCustomOld = prizeMapper.queryPrizeById(prizeCustom.getId());
        if (null == prizeCustomOld) {
            response.setSuccess(false);
            response.setErrorMsg("data not found in database");
            return response;
        }
        int result = prizeMapper.removeInLogical(prizeCustom.getId());
        if (result > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("update  fail in database");
        }
        return response;
    }

    @Override
    public BaseResponse<Boolean> update(PrizeCustom prizeCustom) {
        BaseResponse<Boolean> response = new BaseResponse();
        if (null == prizeCustom) {
            response.setSuccess(false);
            response.setErrorMsg("prizeCustom is null");
            return response;
        }
        //先查询奖品是否已经存在
        PrizeCustom prizeCustomOld = prizeMapper.queryPrizeById(prizeCustom.getId());
        if (null == prizeCustomOld) {
            response.setSuccess(false);
            response.setErrorMsg("data not found in database");
            return response;
        }
        int update = prizeMapper.update(prizeCustom);
        if (update > 0) {
            response.setSuccess(true);
            response.setObj(true);
        } else {
            response.setSuccess(false);
            response.setErrorMsg("update  fail in database");
        }
        return response;
    }

    @Override
    public BaseResponse<PrizeCustom> queryPrizeById(PrizeCustom prizeCustom) {
        BaseResponse<PrizeCustom> response = new BaseResponse<>();
        if (null == prizeCustom) {
            response.setSuccess(false);
            response.setErrorMsg("prizeCustom is null ");
            return response;
        }
        PrizeCustom prizeCustomQuery = prizeMapper.queryPrizeById(prizeCustom.getId());
        response.setSuccess(true);
        response.setObj(prizeCustomQuery);
        return response;
    }

    @Override
    public BaseResponse<List<PrizeCustom>> queryPrizeByTitle(String title) {
        BaseResponse<List<PrizeCustom>> response = new BaseResponse<>();
        List<PrizeCustom> prizeCustoms = prizeMapper.queryPrizeByTitle(title);
        response.setObj(prizeCustoms);
        return response;
    }

    @Override
    public BaseResponse<List<PrizeCustom>> queryPrizeList(PrizeQueryVo prizeQueryVo) {
        BaseResponse<List<PrizeCustom>> response = new BaseResponse<>();
        List<PrizeCustom> prizeCustoms = prizeMapper.queryPrizeList(prizeQueryVo);
        response.setSuccess(true);
        response.setObj(prizeCustoms);
        return response;
    }

    @Override
    public BaseResponse<Integer> queryPrizeCount(PrizeQueryVo prizeQueryVo) {
        BaseResponse<Integer> response = new BaseResponse<>();
        int count = prizeMapper.queryPrizeCount(prizeQueryVo);
        response.setSuccess(true);
        response.setObj(count);
        return response;
    }
}