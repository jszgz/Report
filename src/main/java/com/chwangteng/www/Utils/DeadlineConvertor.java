package com.chwangteng.www.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DeadlineConvertor {

    public final static Map chinese2english = new HashMap<String,String>() {{
        put("周一", "Mon");
        put("周二", "Tue");
        put("周三", "Wed");
        put("周四", "Thu");
        put("周五", "Fri");
        put("周六", "Sat");
        put("周日", "Sun");
    }};

    public final static Map english2chinese = new HashMap<String,String>() {{
        put("Mon", "周一");
        put("Tue", "周二");
        put("Wed", "周三");
        put("Thu", "周四");
        put("Fri", "周五");
        put("Sat", "周六");
        put("Sun", "周日");
    }};

    public static String chinese2english(String chinese){
        return chinese2english.get(chinese).toString();
    }
    public static String english2chinese(String chinese){
        return english2chinese.get(chinese).toString();
    }

    public static String Time2String(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return ""+calendar.get(Calendar.HOUR_OF_DAY)+calendar.get(Calendar.MINUTE);
    }

    public static Date String2Time(String str){
        int hour = Integer.parseInt(str.substring(0,2));
        int minute = Integer.parseInt(str.substring(2));
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        Date aimdate = calendar.getTime();
        return aimdate;
    }
}
