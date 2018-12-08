package com.chwangteng.www.pojo;


import java.util.Date;

public class ReportWithBLOBs extends Report {
    private String thisWeek;

    private String bugMeet;

    private String nextWeek;

    private String reply;

    public String getThisWeek() {
        return thisWeek;
    }

    public void setThisWeek(String thisWeek) {
        this.thisWeek = thisWeek;
    }

    public String getBugMeet() {
        return bugMeet;
    }


    public ReportWithBLOBs(Integer id, String title, Integer studentId, Integer pv, Integer score, Date submitTime, Date replyTime, String thisWeek, String bugMeet, String nextWeek, String reply) {
        super(id, title, studentId, pv, score, submitTime, replyTime);
        this.thisWeek = thisWeek;
        this.bugMeet = bugMeet;
        this.nextWeek = nextWeek;
        this.reply = reply;
    }

    public ReportWithBLOBs() {
        super();
    }
    public void setBugMeet(String bugMeet) {
        this.bugMeet = bugMeet;
    }

    public String getNextWeek() {
        return nextWeek;
    }

    public void setNextWeek(String nextWeek) {
        this.nextWeek = nextWeek;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}