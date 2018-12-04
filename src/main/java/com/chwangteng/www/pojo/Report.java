package com.chwangteng.www.pojo;

import java.util.Date;

public class Report {
    private Integer id;

    private String title;

    private Integer studentId;

    private Integer pv;

    private Integer score;

    private Date submitTime;

    private Date replyTime;

    public Report(Integer id, String title, Integer studentId, Integer pv, Integer score, Date submitTime, Date replyTime) {
        this.id = id;
        this.title = title;
        this.studentId = studentId;
        this.pv = pv;
        this.score = score;
        this.submitTime = submitTime;
        this.replyTime = replyTime;
    }

    public Report() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}