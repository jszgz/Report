package com.chwangteng.www.controller;


import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.mapper.AuthorityMapper;
import com.chwangteng.www.mapper.NotificationMapper;
import com.chwangteng.www.mapper.TeacherMapper;
import com.chwangteng.www.param.*;
import com.chwangteng.www.pojo.*;
import com.chwangteng.www.service.ReportService;
import com.chwangteng.www.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportMapper reportMapper;
    @Autowired
    private ReportService reportService;
    @Autowired
    private NotificationMapper notificationMapper;
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private TeacherMapper teacherMapper;

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
    public ModelAndView viewReport(@RequestBody int id, HttpSession session){
        Report report = new ReportWithBLOBs();
        report.setId(id);
        Report record = reportMapper.selectByPrimaryKey(id);

        int currentstudent = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());
        if(usertype==ConstVar._STUDENT_){
            if(currentstudent==record.getStudentId()){
                ModelAndView mv = new ModelAndView();
                mv.addObject("report",record);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_BAN_);
        map.put(ConstVar._KEY_MESSAGE_, "只能查看自己的周报，请在对应菜单中查看老师分享的周报");
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    //学生编辑后提交周报
    @RequestMapping("/editReport.action")
    public ModelAndView editReport(@RequestBody UpdateReportParam updateReportParam, HttpSession session){
        //防止篡改
        Report old = reportMapper.selectByPrimaryKey(updateReportParam.getReportid());
        if(old!=null) {
            int oldstudent = old.getStudentId();
            int currentstudent = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
            if(oldstudent!=currentstudent) {
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                map.put(ConstVar._KEY_MESSAGE_, "请不要篡改他人的周报，你的行为已经被系统记录");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }
        //开始更新
        ReportWithBLOBs report = new ReportWithBLOBs();
        report.setId(updateReportParam.getReportid());
        report.setSubmitTime(new Date());
        ((ReportWithBLOBs) report).setThisWeek(updateReportParam.getThisWeek());
        ((ReportWithBLOBs) report).setBugMeet(updateReportParam.getBugMeet());
        ((ReportWithBLOBs) report).setNextWeek(updateReportParam.getNextWeek());
        int rows = reportMapper.updateByPrimaryKeySelective(report);
        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_MESSAGE_, "周报更新成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，周报提交失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //查看同门的周报
    @RequestMapping("/viewPeersReport.action")
    public ModelAndView viewPeersReport(@RequestBody ViewPeersReportParam viewPeersReportParam, HttpSession session){
        int currentstudent = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());
        if(usertype==ConstVar._STUDENT_){
            List<ReportWithBLOBs> reports = (List<ReportWithBLOBs>) reportService.getPeersReport(currentstudent, viewPeersReportParam);
            if(reports!=null){
                ModelAndView mv = new ModelAndView();
                mv.addObject(ConstVar._KEY_DATA_,reports);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }else{
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                map.put(ConstVar._KEY_MESSAGE_, "内部错误");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "不是学生，没有权限");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //查看自己学生的周报
    @RequestMapping("/viewStudentsReport.action")
    public ModelAndView viewStudentsReport(@RequestBody ViewStudentsReportParam viewStudentsReportParam, HttpSession session){
        int currentteacher = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());
        if(usertype==ConstVar._TEACHER_){
            List<ReportWithBLOBs> reports = (List<ReportWithBLOBs>) reportService.viewStudentsReport(currentteacher, viewStudentsReportParam);
            if(reports!=null){
                ModelAndView mv = new ModelAndView();
                mv.addObject(ConstVar._KEY_DATA_,reports);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }else{
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                map.put(ConstVar._KEY_MESSAGE_, "发生错误");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "不是老师，没有权限");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //老师评论周报
    @RequestMapping("/replyStudentsReport.action")
    public ModelAndView replyStudentsReport(@RequestBody ReplyStudentsReportParam replyStudentsReportParam, HttpSession session){
        int currentteacher = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());
        if(usertype==ConstVar._TEACHER_){
            ReportWithBLOBs reportWithBLOBs = new ReportWithBLOBs();
            reportWithBLOBs.setReply(replyStudentsReportParam.getReply());
            reportWithBLOBs.setScore(replyStudentsReportParam.getScore());
            reportWithBLOBs.setReplyTime(new Date());
            reportWithBLOBs.setId(replyStudentsReportParam.getId());
            int rows = reportMapper.updateByPrimaryKeySelective(reportWithBLOBs);
            if(rows==1){
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_MESSAGE_, "评分成功");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }else{
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                map.put(ConstVar._KEY_MESSAGE_, "未知错误，评分失败");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "不是老师，没有权限");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //检查自己的通知
    @RequestMapping("/checkMyNotification.action")
    public ModelAndView checkMyNotification(HttpSession session){
        int currentuser = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());

        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andUserIdEqualTo(currentuser).andUserTypeEqualTo(usertype);

        List records = notificationMapper.selectByExample(notificationExample);

        if(records!=null){
            ModelAndView mv = new ModelAndView();
            mv.addObject(ConstVar._KEY_DATA_,records);
            mv.setView(new MappingJackson2JsonView());
            return mv;
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "内部异常");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //将通知设未已读
    @RequestMapping("/setReadFlag")
    public ModelAndView setReadFlag(@RequestBody SetReadFlagParam setReadFlagParam, HttpSession session){
        Notification notification =  new Notification();
        notification.setRead(1);

        int rows = notificationMapper.updateByPrimaryKeySelective(notification);

        if(rows==1){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_MESSAGE_, "已读成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "内部异常");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //导师将周报分享给指定的老师或同学
    @Transactional
    @RequestMapping("/shareToPerson.action")
    public ModelAndView shareToPerson(@RequestBody ShareToPersonParam shareToPersonParam, HttpSession session){

        int currentuser = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());

        if(usertype==ConstVar._TEACHER_){
            Authority authority = new Authority();
            authority.setReportId(shareToPersonParam.getReport_id());
            authority.setTeacherId(currentuser);
            authority.setUserId(shareToPersonParam.getUser_id());

            int rows = authorityMapper.insertSelective(authority);
            if(rows==1){
                Notification notification = new Notification();
                notification.setUserId(shareToPersonParam.getUser_id());
                notification.setUserType(shareToPersonParam.getUser_type());
                notification.setTitle("您收到一篇新的周报推荐");
                notification.setContent(teacherMapper.selectByPrimaryKey(currentuser).getName()+"给您分享了一篇周报，请在分享周报中查阅");
                int rows_noti = notificationMapper.insert(notification);
                if(rows_noti==1){
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put(ConstVar._KEY_MESSAGE_, "分享成功");
                    return new ModelAndView(new MappingJackson2JsonView(),map);
                }else{
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                    map.put(ConstVar._KEY_MESSAGE_, "分享失败");
                    return new ModelAndView(new MappingJackson2JsonView(),map);
                }

            }else{
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                map.put(ConstVar._KEY_MESSAGE_, "分享授权失败");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_BAN_);
            map.put(ConstVar._KEY_MESSAGE_, "没有权限");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }

    //查看老师分享给自己的周报
    @RequestMapping("/viewSharedReports.action")
    public ModelAndView viewSharedReports(@RequestBody ViewSharedReports viewSharedReports, HttpSession session){
        int currentuser = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_ID_).toString());
        int usertype = Integer.parseInt(session.getAttribute(ConstVar._SESSION_USER_TYPE_).toString());

        AuthorityExample authorityExample = new AuthorityExample();
        authorityExample.createCriteria().andUserIdEqualTo(currentuser).andUserTypeEqualTo(usertype);

        List<Authority> auths = authorityMapper.selectByExample(authorityExample);

        if(auths!=null){
            List<Integer> auths_int = new ArrayList<Integer>();
            for (int i=0;i<auths.size();i++){
                auths_int.add(auths.get(i).getReportId());
            }

            ReportExample reportExample = new ReportExample();
            reportExample.createCriteria().andIdIn(auths_int);

            List repotrs =  reportMapper.selectByExampleWithBLOBs(reportExample);
            if(repotrs!=null){
                ModelAndView mv = new ModelAndView();
                mv.addObject(ConstVar._KEY_DATA_,repotrs);
                mv.setView(new MappingJackson2JsonView());
                return mv;
            }
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
        map.put(ConstVar._KEY_MESSAGE_, "内部错误");
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }
}
