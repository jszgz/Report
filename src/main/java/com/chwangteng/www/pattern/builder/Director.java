package com.chwangteng.www.pattern.builder;

public class Director {
    private Builder builder;
    public Director(Builder builder)
    {
        this.builder=builder;
    }
    //产品构建与组装方法
    public Title construct()
    {
        builder.buildName();
        builder.buildTime();
        return builder.getResult();
    }
}
