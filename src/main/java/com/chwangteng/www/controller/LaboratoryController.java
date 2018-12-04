package com.chwangteng.www.controller;

import com.chwangteng.www.Utils.ConstVar;
import com.chwangteng.www.mapper.LaboratoryMapper;
import com.chwangteng.www.mapper.TeacherMapper;
import com.chwangteng.www.param.AddLabRequestParam;
import com.chwangteng.www.param.DeleteLabRequestParam;
import com.chwangteng.www.param.SelectLabRequestParam;
import com.chwangteng.www.param.UpdateLabRequestParam;
import com.chwangteng.www.pojo.Laboratory;
import com.chwangteng.www.pojo.LaboratoryExample;
import com.chwangteng.www.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lab")
public class LaboratoryController {

    @Autowired
    private LaboratoryMapper labMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    //新增实验室
    @RequestMapping("/addLab.action")
    public ModelAndView addLab(@RequestBody AddLabRequestParam addLabRequestParam)   {
        Laboratory lab = new Laboratory();
        lab.setAbout(addLabRequestParam.getAbout());
        lab.setAddress(addLabRequestParam.getAddress());
        lab.setName(addLabRequestParam.getName());
        lab.setTeacherId(addLabRequestParam.getTeacher_id());//还需要更改教师表的关联，以及标志位
        int rows = labMapper.insertSelective(lab);
        if(rows==1){
            //如果填写了主管老师，更新教师表
            if(lab.getTeacherId()!=null){
                //更新教师表
                Teacher teacher = teacherMapper.selectByPrimaryKey(addLabRequestParam.getTeacher_id());
                if(teacher!=null){
                    teacher.setLabId(lab.getId());
                    //更新标志位
                    teacher.setIsSupervisor(ConstVar._SUPER_YES_);
                    int tearows = teacherMapper.updateByPrimaryKeySelective(teacher);
                    if(tearows==1){
                        Map<String,Object> map = new HashMap<String,Object>();
                        map.put(ConstVar._KEY_MESSAGE_, "新增实验室成功");
                        return new ModelAndView(new MappingJackson2JsonView(),map);
                    }else{
                        Map<String,Object> map = new HashMap<String,Object>();
                        map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
                        map.put(ConstVar._KEY_MESSAGE_, "更新该实验室的主管老师失败");
                        return new ModelAndView(new MappingJackson2JsonView(),map);
                    }
                }else{
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
                    map.put(ConstVar._KEY_MESSAGE_, "没有找到该实验室的主管老师");
                    return new ModelAndView(new MappingJackson2JsonView(),map);
                }
            }else{//没有填写主管老师，直接成功
                Map<String,Object> map = new HashMap<String,Object>();
                map.put(ConstVar._KEY_MESSAGE_, "新增实验室成功");
                return new ModelAndView(new MappingJackson2JsonView(),map);
            }
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，新增实验室失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }

    }

    //删除实验室
    @RequestMapping("/deleteLab.action")
    public ModelAndView deleteLab(@RequestBody DeleteLabRequestParam deleteLabRequestParam)   {

        int rows = labMapper.deleteByPrimaryKey(deleteLabRequestParam.getId());
        Map<String,Object> map = new HashMap<String,Object>();
        if(rows==1){
            map.put(ConstVar._KEY_MESSAGE_, "删除实验室成功");
        }else if(rows==0) {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "不存在该实验室");
        }else {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，删除实验室失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }

    //更新实验室信息//还需要更改教师表的关联，以及标志位
    @RequestMapping("updateLab.action")
    public ModelAndView updateLab(@RequestBody UpdateLabRequestParam updateLabRequestParam){
        Laboratory laboratory = new Laboratory();
        laboratory.setId(updateLabRequestParam.getId());
        laboratory.setTeacherId(updateLabRequestParam.getTeacher_id());//还需要更改教师表的关联，以及标志位
        laboratory.setName(updateLabRequestParam.getName());
        laboratory.setAddress(updateLabRequestParam.getAddress());
        laboratory.setAbout(updateLabRequestParam.getAbout());

        int rows = labMapper.updateByPrimaryKeySelective(laboratory);
        Map<String,Object> map = new HashMap<String,Object>();
        if(rows==1){
            map.put(ConstVar._KEY_MESSAGE_, "更新实验室成功");
        }else if(rows==0) {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "不存在该实验室");
        }else {
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_COMMON_);
            map.put(ConstVar._KEY_MESSAGE_, "未知错误，更新实验室失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }



    //查找实验室信息
    @RequestMapping("selectLab.action")
    public ModelAndView selectLab(@RequestBody SelectLabRequestParam selectLabRequestParam){

        LaboratoryExample laboratoryExample = new LaboratoryExample();
        laboratoryExample.createCriteria();

        //需要返回resultList和itemsCount
        List records = labMapper.selectByExample(laboratoryExample);

        if(records.size()!=0){
            ModelAndView mv = new ModelAndView();
            mv.addObject(ConstVar._KEY_DATA_,records);
            mv.setView(new MappingJackson2JsonView());
            return mv;
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put(ConstVar._KEY_CODE_, ConstVar._ERROR_NOTFOUND);
            map.put(ConstVar._KEY_MESSAGE_, "没有找到实验室");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }
    }
}
