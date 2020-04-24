package com.smile.hrsys.mapper;

import com.smile.hrsys.model.Appraise;
import org.springframework.stereotype.Component;

@Component
public interface AppraiseMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Appraise record);

    int insertSelective(Appraise record);

    Appraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Appraise record);

    int updateByPrimaryKey(Appraise record);
}
