package com.smile.hrsys.mapper;

import com.smile.hrsys.model.Employeetrain;
import org.springframework.stereotype.Component;

@Component
public interface EmployeetrainMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);

    Employeetrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeetrain record);

    int updateByPrimaryKey(Employeetrain record);
}
