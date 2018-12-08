package com.chwangteng.www.service.impl;

import com.chwangteng.www.mapper.ReportMapper;
import com.chwangteng.www.mapper.StudentMapper;
import com.chwangteng.www.mapper.TeacherMapper;
import com.chwangteng.www.param.ViewPeersReportParam;
import com.chwangteng.www.param.ViewStudentsReportParam;
import com.chwangteng.www.pojo.ReportExample;
import com.chwangteng.www.pojo.ReportWithBLOBs;
import com.chwangteng.www.pojo.Student;
import com.chwangteng.www.pojo.StudentExample;
import com.chwangteng.www.service.ReportService;
import com.chwangteng.www.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    public List getPeersReport(int id, ViewPeersReportParam viewPeersReportParam) {

/*        int pageIndex = viewPeersReportParam.getPageIndex();
        int pageSize = viewPeersReportParam.getPageSize();
        int student_id = id;*/

        Student student = studentMapper.selectByPrimaryKey(id);
        int teacher_id = student.getTeacherId();

        StudentExample studentExample= new StudentExample();
        studentExample.createCriteria().andTeacherIdEqualTo(teacher_id);

        ArrayList<Student> peers = (ArrayList<Student>) studentMapper.selectByExample(studentExample);
        ArrayList<Integer> peersids = new ArrayList<Integer>();
        for (int i=0;i<peers.size();i++){
            peersids.add(peers.get(i).getId());
        }


        ReportExample reportExample = new ReportExample();
        reportExample.createCriteria().andStudentIdIn(peersids);
        List peersReport =  reportMapper.selectByExampleWithBLOBs(reportExample);

        return peersReport;
    }

    //老师查看自己学生的周报
    public List viewStudentsReport(int id, ViewStudentsReportParam viewStudentsReportParam){
        int teacher_id = id;

        StudentExample studentExample= new StudentExample();
        studentExample.createCriteria().andTeacherIdEqualTo(teacher_id);

        ArrayList<Student> students = (ArrayList<Student>) studentMapper.selectByExample(studentExample);

        if(students.size()==0||students==null)
            return new ArrayList();

        ArrayList<Integer> studentids = new ArrayList<Integer>();
        for (int i=0;i<students.size();i++){
            studentids.add(students.get(i).getId());
        }

        ReportExample reportExample = new ReportExample();
        reportExample.createCriteria().andStudentIdIn(studentids);
        List peersReport =  reportMapper.selectByExampleWithBLOBs(reportExample);

        if(peersReport.size()==0||peersReport==null)
            return new ArrayList();


        return peersReport;
    }
}
