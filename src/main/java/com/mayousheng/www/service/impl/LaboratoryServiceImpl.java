package com.mayousheng.www.service.impl;

import com.mayousheng.www.mapper.AdminMapper;
import com.mayousheng.www.mapper.LaboratoryMapper;
import com.mayousheng.www.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("laboratoryService")
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    private LaboratoryMapper laboratoryMapper;
}
