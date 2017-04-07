package com.andrew.entity;

/**
 * Created by Andrew on 02.04.2017.
 */
public class Application {
    private int applicationId;
    private int applicantId;
    private int vacancyId;
    private String statusENUM;
    private String applicantName;
    private String applicantSurname;
    private String vacancyPosition;
    private String status;
    private String applicantTelephone;
    private String applicantEmail;


    public Application(int applicationId, int applicantId, int vacancyId, String statusENUM, String status) {
        this.applicationId = applicationId;
        this.applicantId = applicantId;
        this.vacancyId = vacancyId;
        this.statusENUM = statusENUM;
        this.status = status;
    }

    public Application(int applicantId, int vacancyId, String statusENUM, String status) {
        this.applicantId = applicantId;
        this.vacancyId = vacancyId;
        this.statusENUM = statusENUM;
        this.status = status;
    }

    public Application(int applicationId, String applicantName, String applicantSurname, String vacancyPosition, String status, String statusENUM) {
        this.applicationId = applicationId;
        this.statusENUM = statusENUM;
        this.applicantName = applicantName;
        this.applicantSurname = applicantSurname;
        this.vacancyPosition = vacancyPosition;
        this.status = status;
    }

    public Application(int applicationId, String vacancyPosition, String status, String statusENUM) {
        this.applicationId = applicationId;
        this.statusENUM = statusENUM;
        this.vacancyPosition = vacancyPosition;
        this.status = status;

    }

    public Application(int applicationId, String applicantName, String applicantSurname,String applicantTelephone, String applicantEmail, String vacancyPosition, String status, String statusENUM, int applicantId, int vacancyId) {
        this.applicationId = applicationId;
        this.statusENUM = statusENUM;
        this.applicantName = applicantName;
        this.applicantSurname = applicantSurname;
        this.applicantEmail = applicantEmail;
        this.applicantTelephone = applicantTelephone;
        this.vacancyPosition = vacancyPosition;
        this.status = status;
        this.applicantId = applicantId;
        this.vacancyId = vacancyId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getStatusId() {
        return statusENUM;
    }

    public void setStatusId(String statusId) {
        this.statusENUM = statusId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantSurname() {
        return applicantSurname;
    }

    public void setApplicantSurname(String applicantSurname) {
        this.applicantSurname = applicantSurname;
    }

    public String getVacancyPosition() {
        return vacancyPosition;
    }

    public void setVacancyPosition(String vacancyPosition) {
        this.vacancyPosition = vacancyPosition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusENUM() {
        return statusENUM;
    }

    public void setStatusENUM(String statusENUM) {
        this.statusENUM = statusENUM;
    }

    public String getApplicantTelephone() {
        return applicantTelephone;
    }

    public void setApplicantTelephone(String applicantTelephone) {
        this.applicantTelephone = applicantTelephone;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }
}
