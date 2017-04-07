package com.andrew.entity;

public class User {
    private int idApplicant;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private String resume;

    public User(int idApplicant, String login, String name, String surname, String telephone, String email) {
        this.idApplicant = idApplicant;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
    }

    public User(int idApplicant, String login, String password, String name, String surname, String telephone, String email) {
        this.idApplicant = idApplicant;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
    }

    public User(String login, String password, String name, String surname, String telephone, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
    }

    public User(String login, String name, String surname, String telephone, String email, String resume, int idApplicant) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.resume = resume;
        this.idApplicant = idApplicant;
    }



    public int getIdApplicant() {
        return idApplicant;
    }

    public void setIdApplicant(int idApplicant) {
        this.idApplicant = idApplicant;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "User{" +
                "idApplicant=" + idApplicant +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
