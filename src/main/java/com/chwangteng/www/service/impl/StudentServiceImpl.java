package com.chwangteng.www.service.impl;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.service.StudentService;
import com.chwangteng.www.mapper.StudentMapper;
import com.chwangteng.www.pojo.Student;
import com.chwangteng.www.pojo.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //重置学生密码
    public int resetPassword(String username){
        StudentExample StudentExample = new StudentExample();
        StudentExample.createCriteria().andUsernameEqualTo(username);
        List<Student> aimstudents = studentMapper.selectByExample(StudentExample);
        if(aimstudents.size()==1){
            Student aim = aimstudents.get(0);
            aim.setPassword(aim.getUsername().substring(aim.getUsername().length()-6));//后六位
            return studentMapper.updateByPrimaryKeySelective(aim);//will only update non-null fields in the parameter class
        }else if(aimstudents.size()==0){
            return ConstVar._ERROR_NOTFOUND;
        }else{
            return ConstVar._ERROR_COMMON_;
        }
    }
    //修改学生密码
    public int updatePassword(String username, String password){
        StudentExample StudentExample = new StudentExample();
        StudentExample.createCriteria().andUsernameEqualTo(username);
        List<Student> aimstudents = studentMapper.selectByExample(StudentExample);
        if(aimstudents.size()==1){
            Student aim = aimstudents.get(0);
            aim.setPassword(password);//新密码
            return studentMapper.updateByPrimaryKeySelective(aim);//will only update non-null fields in the parameter class
        }else if(aimstudents.size()==0){
            return ConstVar._ERROR_NOTFOUND;
        }else{
            return ConstVar._ERROR_COMMON_;
        }
    }
    //学生修改自己的密码
    public int updateMyPassword(int id, String password){
        Student student = studentMapper.selectByPrimaryKey(id);
        if(student!=null){
            student.setPassword(password);//新密码
            return studentMapper.updateByPrimaryKeySelective(student);//will only update non-null fields in the parameter class
        }else if(student == null){
            return ConstVar._ERROR_NOTFOUND;
        }else{
            return ConstVar._ERROR_COMMON_;
        }
    }
}
