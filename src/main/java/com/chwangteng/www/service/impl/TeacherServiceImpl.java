package com.chwangteng.www.service.impl;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.mapper.TeacherMapper;
import com.chwangteng.www.pojo.Teacher;
import com.chwangteng.www.pojo.TeacherExample;
import com.chwangteng.www.service.TeacherService;
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
            aim.setPassword(aim.getUsername().substring(aim.getUsername().length()-6));//后六位
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
    //老师修改自己的密码
    public int updateMyPassword(int id, String password){
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        if(teacher!=null){
            teacher.setPassword(password);//新密码
            return teacherMapper.updateByPrimaryKeySelective(teacher);//will only update non-null fields in the parameter class
        }else if(teacher == null){
            return ConstVar._ERROR_NOTFOUND;
        }else{
            return ConstVar._ERROR_COMMON_;
        }
    }
}
