package com.mayousheng.www.controller;


import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.mapper.ReportMapper;
import com.mayousheng.www.param.AddReportRequestParam;
import com.mayousheng.www.param.AddTeacherRequestParam;
import com.mayousheng.www.pojo.Report;
import com.mayousheng.www.pojo.ReportWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportMapper reportMapper;

    //新增周报
    @RequestMapping("/addReport.action")
    public ModelAndView addReport(@RequestBody AddReportRequestParam addReportRequestParam)   {
        Report report = new ReportWithBLOBs();
        report.setStudentId(addReportRequestParam.getStudentId());
        report.setSubmitTime(new Date());
        ((ReportWithBLOBs) report).setThisWeek(addReportRequestParam.getThisWeek());
        ((ReportWithBLOBs) report).setBugMeet(addReportRequestParam.getBugMeet());
        ((ReportWithBLOBs) report).setNextWeek(addReportRequestParam.getNextWeek());
        int rows = reportMapper.insert((ReportWithBLOBs) report);
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_MESSAGE_, "周报提交成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，周报提交失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }

    }

    //查看某个周报
    @RequestMapping("/viewReport.action")
    public ModelAndView viewReport(@RequestBody int id){
        Report report = new ReportWithBLOBs();
        report.setId(id);
        Report record = reportMapper.selectByPrimaryKey(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("report",record);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
