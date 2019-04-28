package com.chwangteng.www.pattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class Environment {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Environment(){
        this.strategy = null;
    }

    public Environment(Strategy strategy){
        this.strategy = strategy;
    }

    public int resetPassword(String username) {
        if(this.strategy!=null)
            return strategy.resetPassword(username);
        return 0;
    }
}
