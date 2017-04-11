package com.andrew.entity;

/**
 * Created by Andrew on 02.04.2017.
 */
public class Application {
    private int applicationId;
    private int applicantId;
    private int vacancyId;
    private String applicantName;
    private String applicantSurname;
    private String vacancyPosition;
    private String status;
    private String applicantTelephone;
    private String applicantEmail;

    public Application(ApplicationBuilder builder) {
        this.applicationId = builder.applicationId;
        this.applicantId = builder.applicantId;
        this.vacancyId = builder.vacancyId;
        this.applicantName = builder.applicantName;
        this.applicantSurname = builder.applicantSurname;
        this.vacancyPosition = builder.vacancyPosition;
        this.status = builder.status;
        this.applicantTelephone = builder.applicantTelephone;
        this.applicantEmail = builder.applicantEmail;
    }

    public static class ApplicationBuilder {
        private int applicationId;
        private int applicantId;
        private int vacancyId;
        private String applicantName;
        private String applicantSurname;
        private String vacancyPosition;
        private String status;
        private String applicantTelephone;
        private String applicantEmail;

        public ApplicationBuilder(){}

        public ApplicationBuilder applicationId(int val) {
            applicationId = val;
            return this;
        }

        public ApplicationBuilder applicantId(int val) {
            applicantId = val;
            return this;
        }

        public ApplicationBuilder vacancyId(int val) {
            vacancyId = val;
            return this;
        }

        public ApplicationBuilder applicantName(String val) {
            applicantName = val;
            return this;
        }

        public ApplicationBuilder applicantSurname(String val) {
            applicantSurname = val;
            return this;
        }

        public ApplicationBuilder vacancyPosition(String val) {
            vacancyPosition = val;
            return this;
        }

        public ApplicationBuilder status(String val) {
            status = val;
            return this;
        }

        public ApplicationBuilder applicantTelephone(String val) {
            applicantTelephone = val;
            return this;
        }

        public ApplicationBuilder applicantEmail(String val) {
            applicantEmail = val;
            return this;
        }

        public Application build() {
            return new Application(this);
        }
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
