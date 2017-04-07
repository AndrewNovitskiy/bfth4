package com.andrew.entity;

/**
 * Created by Andrew on 31.03.2017.
 */
public class Admin {
    private int idAdmin;
    private String login;
    private String password;

    public Admin(int id_admin, String login, String password) {
        this.idAdmin = id_admin;
        this.login = login;
        this.password = password;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
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

    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
