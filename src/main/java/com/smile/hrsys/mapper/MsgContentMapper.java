package com.smile.hrsys.mapper;

import com.smile.hrsys.model.MsgContent;
import org.springframework.stereotype.Component;

@Component
public interface MsgContentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MsgContent record);

    int insertSelective(MsgContent record);

    MsgContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgContent record);

    int updateByPrimaryKey(MsgContent record);

}
