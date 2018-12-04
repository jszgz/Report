package com.chwangteng.www.service.impl;

import com.chwangteng.www.mapper.LaboratoryMapper;
import com.chwangteng.www.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("laboratoryService")
public class LaboratoryServiceImpl implements LaboratoryService {

    @Autowired
    private LaboratoryMapper laboratoryMapper;
}
