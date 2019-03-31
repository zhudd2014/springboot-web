///**
// * Copyright (C), 2015-2019, XXX有限公司
// * FileName: JoinListener
// * Author:   admin
// * Date:     2019/3/31 18:12
// * Description: 参与监听器
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.szxfd.springboot.web.listener.impl;
//
//import com.szxfd.springboot.web.dao.ParticipantMapper;
//import com.szxfd.springboot.web.listener.Listener;
//import com.szxfd.springboot.web.listener.ListenerManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈参与监听器〉
// * 当有人参与活动时的监听器
// *
// * @author admin
// * @create 2019/3/31
// * @since 1.0.0
// */
//@Component
//public class JoinListener implements Listener {
//
//    public static final String LISTENER_PARTICIPANT_JOIN = "listener_participant_join";
//    @Resource
//    private ParticipantMapper participantMapper;
//    @Autowired
//    private ListenerManager listenerManager;
//
//    @Override
//    public void onNitify() {
//        //有新的参与者，检查是否达到了开奖人数上限，若达到了任务上限，则开奖
//        participantMapper.queryParticipantById()
//    }
//
//    @Autowired
//    public void setListener(JoinListener joinListener) {
//        listenerManager.registerListener(LISTENER_PARTICIPANT_JOIN, joinListener);
//    }
//}