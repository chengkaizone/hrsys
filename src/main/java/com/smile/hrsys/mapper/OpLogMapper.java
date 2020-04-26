package com.smile.hrsys.mapper;

import com.smile.hrsys.model.OpLog;
import org.springframework.stereotype.Component;

@Component
public interface OpLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    OpLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);
}
