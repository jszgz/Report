package com.mayousheng.www.service.impl;

import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.mapper.LaboratoryMapper;
import com.mayousheng.www.mapper.TeacherMapper;
import com.mayousheng.www.pojo.Teacher;
import com.mayousheng.www.pojo.TeacherExample;
import com.mayousheng.www.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    //重置老师密码
    public int resetPassword(String username){
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andUsernameEqualTo(username);
        List<Teacher> aimteachers = teacherMapper.selectByExample(teacherExample);
        if(aimteachers.size()==1){
            Teacher aim = aimteachers.get(0);
            aim.setPassword(aim.getPassword().substring(aim.getPassword().length()-6));//后六位
            return teacherMapper.updateByPrimaryKeySelective(aim);//will only update non-null fields in the parameter class
        }else if(aimteachers.size()==0){
            return ConstVar._ERROR_NOTFOUND;
        }else{
            return ConstVar._ERROR_COMMON_;
        }
    }
    //修改老师密码
    public int updatePassword(String username, String password){
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andUsernameEqualTo(username);
        List<Teacher> aimteachers = teacherMapper.selectByExample(teacherExample);
        if(aimteachers.size()==1){
            Teacher aim = aimteachers.get(0);
            aim.setPassword(password);//新密码
            return teacherMapper.updateByPrimaryKeySelective(aim);//will only update non-null fields in the parameter class
        }else if(aimteachers.size()==0){
            return ConstVar._ERROR_NOTFOUND;
        }else{
            return ConstVar._ERROR_COMMON_;
        }
    }
}
