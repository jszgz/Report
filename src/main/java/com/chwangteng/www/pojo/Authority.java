package com.chwangteng.www.pojo;

public class Authority {
    private Integer id;

    private Integer teacherId;

    private Integer userId;

    private Integer userType;

    private Integer reportId;

    public Authority(Integer id, Integer teacherId, Integer userId, Integer userType, Integer reportId) {
        this.id = id;
        this.teacherId = teacherId;
        this.userId = userId;
        this.userType = userType;
        this.reportId = reportId;
    }

    public Authority() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }
}