package com.chwangteng.www.pojo;

public class Laboratory {
    private Integer id;

    private Integer teacherId;

    private String name;

    private String address;

    private String about;

    public Laboratory(Integer id, Integer teacherId, String name, String address, String about) {
        this.id = id;
        this.teacherId = teacherId;
        this.name = name;
        this.address = address;
        this.about = about;
    }

    public Laboratory() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}