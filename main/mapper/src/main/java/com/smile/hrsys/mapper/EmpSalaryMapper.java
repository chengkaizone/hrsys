package com.smile.hrsys.mapper;

import com.smile.hrsys.model.EmpSalary;

public interface EmpSalaryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(EmpSalary record);

    int insertSelective(EmpSalary record);

    EmpSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmpSalary record);

    int updateByPrimaryKey(EmpSalary record);
}
