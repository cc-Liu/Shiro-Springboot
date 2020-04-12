package com.lc.entity;

public class User {

    private int id;

    private String name;

    private String pwd;

    private String perm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public User(int id, String name, String pwd, String perm) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.perm = perm;
    }

    public User() {
    }
}
