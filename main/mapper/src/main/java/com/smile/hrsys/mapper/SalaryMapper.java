package com.smile.hrsys.mapper;

import com.smile.hrsys.model.Salary;

import java.util.List;

public interface SalaryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeSelectivey(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaries();

}
