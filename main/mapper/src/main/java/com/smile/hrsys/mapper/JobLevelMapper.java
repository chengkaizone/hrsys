package com.smile.hrsys.mapper;

import com.smile.hrsys.model.JobLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobLevelMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSElective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevel();

    Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids);

}
