package com.chwangteng.www.pojo;

import java.util.Date;

public class Notification {
    private Integer id;

    private Integer userId;

    private Integer userType;

    private Date generateTime;

    private String title;

    private String content;

    private Integer read;

    public Notification(Integer id, Integer userId, Integer userType, Date generateTime, String title, String content, Integer read) {
        this.id = id;
        this.userId = userId;
        this.userType = userType;
        this.generateTime = generateTime;
        this.title = title;
        this.content = content;
        this.read = read;
    }

    public Notification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }
}