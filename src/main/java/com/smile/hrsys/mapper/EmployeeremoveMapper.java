package com.smile.hrsys.mapper;

import com.smile.hrsys.model.Employeeremove;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeremoveMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employeeremove record);

    int insertSelective(Employeeremove record);

    Employeeremove selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeremove record);

    int updateByPrimaryKey(Employeeremove record);
}
