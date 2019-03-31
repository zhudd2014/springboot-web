/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ParticipantController
 * Author:   admin
 * Date:     2019/3/23 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.szxfd.springboot.web.controller;

import com.szxfd.springboot.web.entity.BaseResponse;
import com.szxfd.springboot.web.entity.ParticipantCustom;
import com.szxfd.springboot.web.entity.ParticipantQueryVo;
import com.szxfd.springboot.web.service.IParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author admin
 * @create 2019/3/23
 * @since 1.0.0
 */
@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private IParticipantService participantService;

    /**
     * 参与活动
     *
     * @return
     */
    @RequestMapping("/join")
    public BaseResponse join(@RequestBody ParticipantCustom participantCustom) {
        return participantService.join(participantCustom);
    }

    /**
     * @return
     */
    @RequestMapping("/queryParticipantList")
    public BaseResponse queryParticipantList(@RequestBody(required = false) ParticipantQueryVo participantQueryVo) {
        return participantService.queryParticipantList(participantQueryVo);
    }

    /**
     * @return
     */
    @RequestMapping("/queryParticipantCount")
    public BaseResponse queryParticipantCount(@RequestBody(required = false) ParticipantQueryVo participantQueryVo) {
        return participantService.queryParticipantCount(participantQueryVo);
    }
}