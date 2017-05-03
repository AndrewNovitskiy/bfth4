package com.andrew.entity;

public class User {
    private int applicantId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private String resume;

    public User(UserBuilder builder) {
        this.applicantId = builder.idApplicant;
        this.login = builder.login;
        this.password = builder.password;
        this.name = builder.name;
        this.surname = builder.surname;
        this.telephone = builder.telephone;
        this.email = builder.email;
        this.resume = builder.resume;

    }


    public static class UserBuilder {
        private int idApplicant;
        private String login;
        private String password;
        private String name;
        private String surname;
        private String telephone;
        private String email;
        private String resume;

        public UserBuilder(){}

        public UserBuilder idApplicant(int val) {
            idApplicant = val;
            return this;
        }

        public UserBuilder login(String val) {
            login = val;
            return this;
        }

        public UserBuilder password(String val) {
            password = val;
            return this;
        }

        public UserBuilder name(String val) {
            name = val;
            return this;
        }

        public UserBuilder surname(String val) {
            surname = val;
            return this;
        }

        public UserBuilder telephone(String val) {
            telephone = val;
            return this;
        }

        public UserBuilder email(String val) {
            email = val;
            return this;
        }

        public UserBuilder resume(String val) {
            resume = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
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
}
