package com.chwangteng.www.pojo;

public class Admin {
    private Integer id;

    private String username;

    private String password;

    private String token;

    private String name;

    public Admin(Integer id, String username, String password, String token, String name) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.name = name;
    }

    public Admin() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}