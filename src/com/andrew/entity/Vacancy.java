package com.andrew.entity;

import java.sql.Timestamp;

/**
 * Created by Andrew on 02.04.2017.
 */
public class Vacancy {
    private int vacancyId;
    private Timestamp dateTime;
    private String position;
    private int experience;
    private int salary;
    private String info;

    public Vacancy(int vacancyId, Timestamp dateTime, String position, int experience, int salary) {
        this.vacancyId = vacancyId;
        this.dateTime = dateTime;
        this.position = position;
        this.experience = experience;
        this.salary = salary;
        this.info = info;
    }

    public Vacancy(int vacancyId, Timestamp dateTime, String position, int experience, int salary, String info) {
        this.vacancyId = vacancyId;
        this.dateTime = dateTime;
        this.position = position;
        this.experience = experience;
        this.salary = salary;
        this.info = info;
    }

    public Vacancy(Timestamp dateTime, String position, int experience, int salary, String info) {
        this.dateTime = dateTime;
        this.position = position;
        this.experience = experience;
        this.salary = salary;
        this.info = info;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
