package com.smile.hrsys.mapper;

import com.smile.hrsys.model.Salary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SalaryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);

    List<Salary> getAllSalaries();

}
