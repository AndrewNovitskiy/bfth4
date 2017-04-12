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
    private boolean deleted;

    public Vacancy(VacancyBuilder builder) {
        this.vacancyId = builder.vacancyId;
        this.dateTime = builder.dateTime;
        this.position = builder.position;
        this.experience = builder.experience;
        this.salary = builder.salary;
        this.info = builder.info;
        this.deleted = builder.deleted;
    }


    public static class VacancyBuilder {
        private int vacancyId;
        private Timestamp dateTime;
        private String position;
        private int experience;
        private int salary;
        private String info;
        private boolean deleted;

        public VacancyBuilder(){}


        public VacancyBuilder vacancyId(int val) {
            vacancyId = val;
            return this;
        }

        public VacancyBuilder dateTime(Timestamp val) {
            dateTime = val;
            return this;
        }

        public VacancyBuilder position(String val) {
            position = val;
            return this;
        }

        public VacancyBuilder experience(int val) {
            experience = val;
            return this;
        }

        public VacancyBuilder salary(int val) {
            salary = val;
            return this;
        }

        public VacancyBuilder info(String val) {
            info = val;
            return this;
        }

        public VacancyBuilder deleted(boolean val) {
            deleted = val;
            return this;
        }

        public Vacancy build() {
            return new Vacancy(this);
        }



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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
