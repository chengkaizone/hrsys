package com.smile.hrsys.mapper;

import com.smile.hrsys.model.SysMsg;

public interface SysMsgMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysMsg record);

    int insertSelective(SysMsg record);

    SysMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMsg record);

    int updateByPrimaryKey(SysMsg record);

}
