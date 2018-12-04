package com.chwangteng.www.pojo;

public class Teacher {
    private Integer id;

    private Integer isSupervisor;

    private String about;

    private String sex;

    private String telephone;

    private String mail;

    private String token;

    private String name;

    private Integer labId;

    private String deadline;

    private String username;

    private String password;

    public Teacher(Integer id, Integer isSupervisor, String about, String sex, String telephone, String mail, String token, String name, Integer labId, String deadline, String username, String password) {
        this.id = id;
        this.isSupervisor = isSupervisor;
        this.about = about;
        this.sex = sex;
        this.telephone = telephone;
        this.mail = mail;
        this.token = token;
        this.name = name;
        this.labId = labId;
        this.deadline = deadline;
        this.username = username;
        this.password = password;
    }

    public Teacher() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsSupervisor() {
        return isSupervisor;
    }

    public void setIsSupervisor(Integer isSupervisor) {
        this.isSupervisor = isSupervisor;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
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

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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