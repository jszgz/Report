package com.mayousheng.www.controller;

import com.mayousheng.www.Utils.ConstVar;
import com.mayousheng.www.mapper.LaboratoryMapper;
import com.mayousheng.www.param.AddLabRequestParam;
import com.mayousheng.www.param.DeleteLabRequestParam;
import com.mayousheng.www.param.ResetPasswordRequestParam;
import com.mayousheng.www.pojo.Laboratory;
import com.mayousheng.www.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/lab")
public class LaboratoryController {

    @Autowired
    private LaboratoryService labService;
    @Autowired
    private LaboratoryMapper labMapper;

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
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("message", "新增实验室成功");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }else{
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("code", ConstVar._ERROR_COMMON_);
            map.put("message", "未知错误，新增实验室失败");
            return new ModelAndView(new MappingJackson2JsonView(),map);
        }

    }

    //删除实验室
    @RequestMapping("/deleteLab.action")
    public ModelAndView deleteLab(@RequestBody DeleteLabRequestParam deleteLabRequestParam)   {

        int rows = labMapper.deleteByPrimaryKey(deleteLabRequestParam.getId());
        Map<String,Object> map = new HashMap<String,Object>();
        if(rows==1){
            map.put("message", "删除实验室成功");
        }else if(rows==0) {
            map.put("code", ConstVar._ERROR_NOTFOUND);
            map.put("message", "不存在该实验室");
        }else {
            map.put("code", ConstVar._ERROR_COMMON_);
            map.put("message", "未知错误，删除实验室失败");
        }
        return new ModelAndView(new MappingJackson2JsonView(),map);
    }


}
