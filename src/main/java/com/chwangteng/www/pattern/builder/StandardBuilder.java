package com.chwangteng.www.pattern.builder;

import java.util.Calendar;
import java.util.Date;

public class StandardBuilder extends Builder {

    public String ctx;

    public StandardBuilder(String ctx){
        this.ctx = ctx;
    }

    public void buildName() {
        title.setName(ctx+"的周报-");
    }

    public void buildTime() {

        String str_time = "";
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        str_time+= (int)calendar.get(Calendar.MONTH)+1+"月";
        str_time+= calendar.get(Calendar.DAY_OF_MONTH)+"日";

        title.setTime(str_time);
    }

}
