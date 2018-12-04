package com.chwangteng.www.service;

import com.chwangteng.www.param.ViewPeersReportParam;
import com.chwangteng.www.param.ViewStudentsReportParam;

import java.util.List;


public interface ReportService {

    //学生查看同门的周报
    public List getPeersReport(int id, ViewPeersReportParam viewPeersReportParam);
    //老师查看自己学生的周报
    public List viewStudentsReport(int id, ViewStudentsReportParam viewStudentsReportParam);
}
