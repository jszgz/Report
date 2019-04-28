package com.chwangteng.www.pattern.strategy;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class StrategyFactory {

    private Map<String,Strategy> strategyMap=new HashMap<String, Strategy>();

    public Map<String, Strategy> getStrategyMap() {
        return strategyMap;
    }

    public void setStrategyMap(Map<String, Strategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public Strategy getStratery(int type){
        return this.strategyMap.get(""+type);
    }
}
