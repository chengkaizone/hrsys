package com.smile.hrsys.mapper;

import com.smile.hrsys.model.AdjustSalary;
import org.springframework.stereotype.Component;

@Component
public interface AdjustSalaryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AdjustSalary record);

    int insertSelective(AdjustSalary record);

    AdjustSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdjustSalary record);

    int updateByPrimaryKey(AdjustSalary record);

}
