package com.chwangteng.www.pattern.strategy;

import org.springframework.stereotype.Component;

import javax.ejb.ConcurrencyManagement;

@Component
public interface Strategy {

    public int resetPassword(String username);
}
