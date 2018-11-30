package com.example.webconsumerservice.model;

/**
 * @author shijy
 * @Date 2018/11/29 10 : 57
 * @Descriprion
 */
public class User {
    private  Integer id;
    private String username;
    private String ctm;
    private Integer age;

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

    public String getCtm() {
        return ctm;
    }

    public void setCtm(String ctm) {
        this.ctm = ctm;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer id, String username, String ctm, Integer age) {
        this.id = id;
        this.username = username;
        this.ctm = ctm;
        this.age = age;
    }

    public User() {
    }
}
