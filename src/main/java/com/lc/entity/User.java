package com.lc.entity;

import java.util.Date;

public class User {

    private int id;

    private String username;

    private String password;

    private String nickname;

    private int role_id;

    private Date create_time;

    private Date update_time;

    private String delete_status;

    public User(int id, String username, String password, String nickname, int role_id, Date create_time, Date update_time, String delete_status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.role_id = role_id;
        this.create_time = create_time;
        this.update_time = update_time;
        this.delete_status = delete_status;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getDelete_status() {
        return delete_status;
    }

    public void setDelete_status(String delete_status) {
        this.delete_status = delete_status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role_id=" + role_id +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                ", delete_status='" + delete_status + '\'' +
                '}';
    }
}
