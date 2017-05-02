package com.andrew.entity;

/**
 * Created by Andrew on 31.03.2017.
 */
public class Admin implements Entity {
    private int adminId;
    private String login;
    private String password;

    public Admin(int id_admin, String login, String password) {
        this.adminId = id_admin;
        this.login = login;
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
