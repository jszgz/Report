package com.chwangteng.www.param;

public class SelectTeacherRequestParam {

    //用于分页
    private Integer pageIndex;
    private Integer pageSize;

    //用于统计结果数量，需要后端返回。即返回一个列表和一个总数。
    //private Integer itemsCount;

    //用于分页排序
    private String sortField;     // the name of sorting field 需要前后端命名一致
    private String sortOrder;     // the order of sorting as string "asc"|"desc"

    //Fields 用于搜索
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

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
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
