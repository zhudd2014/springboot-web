package com.szxfd.springboot.web.dao;

import com.szxfd.springboot.web.entity.Participant;
import com.szxfd.springboot.web.entity.ParticipantCustom;
import com.szxfd.springboot.web.entity.ParticipantPrize;
import com.szxfd.springboot.web.entity.ParticipantQueryVo;

import java.util.List;

public interface ParticipantMapper {

    int insert(ParticipantCustom participantCustom);

    int removeInLogical(int participantId);

    ParticipantCustom queryParticipantById(int id);

    List<ParticipantCustom> queryParticipantList(ParticipantQueryVo participantQueryVo);

    int queryParticipantCount(ParticipantQueryVo participantQueryVo);

    List<Participant> queryAllParticipants();

    List<Participant> queryParticipants(int id);

    Integer setParticipants(ParticipantPrize participantPrize);

}
