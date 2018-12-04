package com.chwangteng.www.param;

import java.util.Date;

public class AddReportRequestParam {

    private String title;

    private Integer studentId;

    private Integer pv;

    private Integer score;

    private Date submitTime;

    private Date replyTime;

    private String thisWeek;

    private String bugMeet;

    private String nextWeek;

    private String reply;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getThisWeek() {
        return thisWeek;
    }

    public void setThisWeek(String thisWeek) {
        this.thisWeek = thisWeek;
    }

    public String getBugMeet() {
        return bugMeet;
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
