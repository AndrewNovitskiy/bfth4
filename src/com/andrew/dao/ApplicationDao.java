package com.andrew.dao;

import com.andrew.connection.ConnectionPool;
import com.andrew.entity.Application;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Andrew on 03.04.2017.
 */
public class ApplicationDao {

    private static final Logger log = Logger.getLogger(ApplicationDao.class);

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static final String SQL_GET_ALL_APPLICATIONS = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status WHERE application.deleted = 0;";

    private static final String SQL_GET_APPLICATION_BY_ID = "SELECT application.id_application, applicant.id_applicant, vacancy.id_vacancy, applicant.name, applicant.surname, applicant.telephone, applicant.email, vacancy.position, application_status.value, application.deleted\n" +
            "            FROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "             LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "\t\t\t LEFT JOIN application_status ON application.id_status = application_status.id_status\n" +
            "             WHERE application.id_application = ?;";

    private static final String SQL_GET_APPLICATIONS_OF_USER = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status " +
            "WHERE application.id_applicant = ? AND application.deleted = 0;";

    private static final String SQL_GET_APPLICATIONS_OF_VACANCY = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status " +
            "WHERE application.id_vacancy = ? AND application.deleted = 0;";

    private static final String SQL_DELETE_APPLICATION = "UPDATE application SET application.deleted = 1 WHERE application.id_application = ?;";
    private static final String SQL_RESTORE_APPLICATION = "UPDATE application SET application.deleted = 0 WHERE application.id_application = ?;";



    private static final String SQL_GET_DELETED_APPLICATIONS = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value, application.deleted\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status WHERE application.deleted = 1;";


    private static final String SQL_UPDATE_APPLICATION_STATUS = "UPDATE application SET application.id_status = ? WHERE application.id_application = ?;";


    private ConnectionPool pool;

    public ApplicationDao() {
        pool = ConnectionPool.getInstance();
    }


    public ArrayList<Application> takeAllApplications(){
        try {
            Application application;
            ArrayList<Application> applications = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ALL_APPLICATIONS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int applicationId = rs.getInt("id_application");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String position = rs.getString("position");
                String status = rs.getString("value");

                application = new Application.ApplicationBuilder().applicationId(applicationId).applicantName(name).applicantSurname(surname).vacancyPosition(position).status(status).build();
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    private void closeResources(Connection conn, PreparedStatement stmt) {
        pool.freeConnection(conn);
        try { stmt.close(); } catch(SQLException se) { log.info("SQLException"); }
    }

    public Application takeApplicationById(Integer applicationId) {
        try {
            Application application = null;
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_APPLICATION_BY_ID);
            stmt.setInt(1, applicationId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String position = rs.getString("position");
                String status = rs.getString("value");
                int applicantId = rs.getInt("id_applicant");
                int vacancyId = rs.getInt("id_vacancy");
                boolean deleted = rs.getBoolean("deleted");
                application = new Application.ApplicationBuilder().applicationId(applicationId).applicantName(name)
                        .applicantSurname(surname).applicantTelephone(telephone).applicantEmail(email)
                        .vacancyPosition(position).status(status).applicantId(applicantId).vacancyId(vacancyId).deleted(deleted).build();
            }
            return application;
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    public ArrayList<Application> takeApplicationsOfUser(int userId) {
        try {
            Application application;
            ArrayList<Application> applications = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_APPLICATIONS_OF_USER);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int applicationId = rs.getInt("id_application");
                String position = rs.getString("position");
                String status = rs.getString("value");

                application = new Application.ApplicationBuilder().applicationId(applicationId).vacancyPosition(position).status(status).build();
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    public ArrayList<Application> takeApplicationsOfVacancy(int vacancyId) {
        try {
            Application application;
            ArrayList<Application> applications = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_APPLICATIONS_OF_VACANCY);
            stmt.setInt(1, vacancyId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int applicationId = rs.getInt("id_application");
                String position = rs.getString("position");
                String status = rs.getString("value");

                String name = rs.getString("name");
                String surname = rs.getString("surname");

                application = new Application.ApplicationBuilder().applicationId(applicationId).applicantName(name)
                        .applicantSurname(surname).vacancyPosition(position).status(status).build();
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    public void deleteApplication(int applicationId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_APPLICATION);
            stmt.setInt(1, applicationId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
        }
    }

    public void restoreApplication(int applicationId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_RESTORE_APPLICATION);
            stmt.setInt(1, applicationId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
        }
    }

    public ArrayList<Application> takeDeletedApplications() {
        try {
            Application application;
            ArrayList<Application> applications = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_DELETED_APPLICATIONS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int applicationId = rs.getInt("id_application");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String position = rs.getString("position");
                String status = rs.getString("value");
                boolean deleted = rs.getBoolean("deleted");
                application = new Application.ApplicationBuilder().applicationId(applicationId).applicantName(name)
                        .applicantSurname(surname).vacancyPosition(position).status(status).deleted(deleted).build();
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    public void changeStatus(int applicationId, int statusId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_APPLICATION_STATUS);
            stmt.setInt(1, statusId);
            stmt.setInt(2, applicationId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
        }
    }
}
