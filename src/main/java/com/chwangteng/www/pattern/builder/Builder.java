package com.chwangteng.www.pattern.builder;

abstract public class Builder {

    //创建产品对象
    protected Title title=new Title();
    public abstract void buildName();
    public abstract void buildTime();
    //返回产品对象
    public Title getResult()
    {
        return title;
    }
}
