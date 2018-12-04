package com.chwangteng.www.pojo;

public class Student {
    private Integer id;

    private String sex;

    private String telephone;

    private String mail;

    private String token;

    private String name;

    private Integer teacherId;

    private String username;

    private String password;

    public Student(Integer id, String sex, String telephone, String mail, String token, String name, Integer teacherId, String username, String password) {
        this.id = id;
        this.sex = sex;
        this.telephone = telephone;
        this.mail = mail;
        this.token = token;
        this.name = name;
        this.teacherId = teacherId;
        this.username = username;
        this.password = password;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}