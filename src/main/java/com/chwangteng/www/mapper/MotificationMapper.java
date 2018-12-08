package com.chwangteng.www.mapper;

import com.chwangteng.www.pojo.Motification;
import com.chwangteng.www.pojo.MotificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MotificationMapper {
    int countByExample(MotificationExample example);

    int deleteByExample(MotificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Motification record);

    int insertSelective(Motification record);

    List<Motification> selectByExample(MotificationExample example);

    Motification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Motification record, @Param("example") MotificationExample example);

    int updateByExample(@Param("record") Motification record, @Param("example") MotificationExample example);

    int updateByPrimaryKeySelective(Motification record);

    int updateByPrimaryKey(Motification record);
}