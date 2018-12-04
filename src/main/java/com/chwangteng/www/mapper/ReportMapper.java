package com.chwangteng.www.mapper;

import com.chwangteng.www.pojo.Report;
import com.chwangteng.www.pojo.ReportExample;
import com.chwangteng.www.pojo.ReportWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportMapper {
    int countByExample(ReportExample example);

    int deleteByExample(ReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReportWithBLOBs record);

    int insertSelective(ReportWithBLOBs record);

    List<ReportWithBLOBs> selectByExampleWithBLOBs(ReportExample example);

    List<Report> selectByExample(ReportExample example);

    ReportWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReportWithBLOBs record, @Param("example") ReportExample example);

    int updateByExampleWithBLOBs(@Param("record") ReportWithBLOBs record, @Param("example") ReportExample example);

    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);

    int updateByPrimaryKeySelective(ReportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ReportWithBLOBs record);

    int updateByPrimaryKey(Report record);
}