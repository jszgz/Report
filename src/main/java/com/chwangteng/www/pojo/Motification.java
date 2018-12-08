package com.chwangteng.www.pojo;

import java.util.Date;

public class Motification {
    private Integer id;

    private Integer userIdMo;

    private Integer userTypeMo;

    private Date generateTimeMo;

    private String titleMo;

    private String contentMo;

    private Integer readMo;

    public Motification(Integer id, Integer userIdMo, Integer userTypeMo, Date generateTimeMo, String titleMo, String contentMo, Integer readMo) {
        this.id = id;
        this.userIdMo = userIdMo;
        this.userTypeMo = userTypeMo;
        this.generateTimeMo = generateTimeMo;
        this.titleMo = titleMo;
        this.contentMo = contentMo;
        this.readMo = readMo;
    }

    public Motification() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIdMo() {
        return userIdMo;
    }

    public void setUserIdMo(Integer userIdMo) {
        this.userIdMo = userIdMo;
    }

    public Integer getUserTypeMo() {
        return userTypeMo;
    }

    public void setUserTypeMo(Integer userTypeMo) {
        this.userTypeMo = userTypeMo;
    }

    public Date getGenerateTimeMo() {
        return generateTimeMo;
    }

    public void setGenerateTimeMo(Date generateTimeMo) {
        this.generateTimeMo = generateTimeMo;
    }

    public String getTitleMo() {
        return titleMo;
    }

    public void setTitleMo(String titleMo) {
        this.titleMo = titleMo;
    }

    public String getContentMo() {
        return contentMo;
    }

    public void setContentMo(String contentMo) {
        this.contentMo = contentMo;
    }

    public Integer getReadMo() {
        return readMo;
    }

    public void setReadMo(Integer readMo) {
        this.readMo = readMo;
    }
}