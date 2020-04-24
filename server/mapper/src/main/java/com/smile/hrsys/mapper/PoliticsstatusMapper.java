package com.smile.hrsys.mapper;

import com.smile.hrsys.model.Politicsstatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PoliticsstatusMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Politicsstatus record);

    int insertSelective(Politicsstatus record);

    Politicsstatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Politicsstatus record);

    int updateByPrimaryKey(Politicsstatus record);

    List<Politicsstatus> getAllPoliticsstatus();

}
