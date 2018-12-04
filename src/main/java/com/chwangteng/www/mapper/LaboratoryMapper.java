package com.chwangteng.www.mapper;

import com.chwangteng.www.pojo.Laboratory;
import com.chwangteng.www.pojo.LaboratoryExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LaboratoryMapper {
    int countByExample(LaboratoryExample example);

    int deleteByExample(LaboratoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Laboratory record);

    int insertSelective(Laboratory record);

    List<Laboratory> selectByExample(LaboratoryExample example);

    Laboratory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Laboratory record, @Param("example") LaboratoryExample example);

    int updateByExample(@Param("record") Laboratory record, @Param("example") LaboratoryExample example);

    int updateByPrimaryKeySelective(Laboratory record);

    int updateByPrimaryKey(Laboratory record);
}