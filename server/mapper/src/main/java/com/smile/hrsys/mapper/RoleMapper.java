package com.smile.hrsys.mapper;

import com.smile.hrsys.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getAllRoles();

}
