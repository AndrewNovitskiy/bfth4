package com.andrew.dao;

import com.andrew.entity.Application;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

import static com.andrew.constant.CommonConstant.SQL_EXCEPTION;

/**
 * Created by Andrew on 03.04.2017.
 */
public class ApplicationDao extends Dao {

    private static final Logger LOG = Logger.getLogger(ApplicationDao.class);

    private static final String SQL_GET_ALL_APPLICATIONS = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status WHERE application.deleted = 0;";

    private static final String SQL_GET_RECRUITED_APPLICATIONS = "SELECT application.id_applicant, applicant.name, applicant.surname, vacancy.position, application_status.value\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status WHERE application.id_status = 4;";

    private static final String SQL_GET_APPLICATION_BY_ID_FOR_ADMIN = "SELECT application.id_application, applicant.id_applicant, vacancy.id_vacancy, applicant.name, applicant.surname, applicant.telephone, applicant.email, vacancy.position, application_status.value, application.deleted\n" +
            "            FROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "             LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "\t\t\t LEFT JOIN application_status ON application.id_status = application_status.id_status\n" +
            "             WHERE application.id_application = ?;";

    private static final String SQL_GET_APPLICATIONS_OF_USER = "SELECT application.id_application, vacancy.id_vacancy, vacancy.position, application_status.value\n" +
            "\tFROM application\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status " +
            "WHERE application.id_applicant = ? AND application.deleted = 0;";

    private static final String SQL_GET_APPLICATIONS_OF_VACANCY = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status " +
            "WHERE application.id_vacancy = ? AND application.deleted = 0;";

    private static final String SQL_DELETE_APPLICATION_BY_ID = "UPDATE application SET application.deleted = 1 WHERE application.id_application = ?;";

    private static final String SQL_DELETE_APPLICATION = "UPDATE application SET application.deleted = 1 WHERE application.id_applicant = ? AND application.id_vacancy = ?;";

    private static final String SQL_RESTORE_APPLICATION_BY_ID = "UPDATE application SET application.deleted = 0 WHERE application.id_application = ?;";

    private static final String SQL_RESTORE_APPLICATION = "UPDATE application SET application.deleted = 0 WHERE application.id_applicant = ? AND application.id_vacancy = ?;";

    private static final String SQL_GET_DELETED_APPLICATIONS = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value, application.deleted\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status WHERE application.deleted = 1;";

    private static final String SQL_UPDATE_APPLICATION_STATUS = "UPDATE application SET application.id_status = ? WHERE application.id_application = ?;";

    private static final String SQL_GET_DELETED_APPLICATIONS_OF_VACANCY = "SELECT application.id_application, applicant.name, applicant.surname, vacancy.position, application_status.value, application.deleted\n" +
            "\tFROM application LEFT JOIN applicant ON application.id_applicant = applicant.id_applicant\n" +
            "\t\t\t\t\t LEFT JOIN vacancy ON application.id_vacancy = vacancy.id_vacancy\n" +
            "                     LEFT JOIN application_status ON application.id_status = application_status.id_status " +
            "WHERE application.id_vacancy = ? AND application.deleted = 1;";

    private static final String SQL_DELETE_APPLICATIONS_OF_VACANCY = "UPDATE application SET application.deleted = 1 WHERE application.id_vacancy = ?;";

    private static final String SQL_PUT_APPLICATION = "INSERT INTO application (id_application, id_applicant, id_vacancy, id_status, deleted) VALUES (NULL, ?, ?, 1, 0);";

    private static final String SQL_CHECK_EXISTENCE_AND_ACTIVITY_OF_APPLICATOIN = "SELECT application.id_application FROM application WHERE id_applicant = ? AND id_vacancy = ? AND deleted = 0;";

    private static final String SQL_CHECK_EXISTENCE_OF_APPLICATOIN = "SELECT application.id_application FROM application WHERE id_applicant = ? AND id_vacancy = ?;";

    private static final String SQL_GET_STATUS_VALUE = "SELECT application_status.value FROM application_status WHERE application_status.id_status = ?;";

    private static final String SQL_GET_ID_USERS_BY_VACANCY_ID = "SELECT application.id_applicant FROM application WHERE application.id_vacancy = ? AND application.deleted = 0 AND NOT (application.id_status = 4 OR application.id_status = 5);";


    public ArrayList<Application> findAllApplications(){
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
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error(SQL_EXCEPTION); }
        }
        return null;
    }



    public Application findApplicationByIdForAdmin(Integer applicationId) {
        try {
            Application application = null;
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_APPLICATION_BY_ID_FOR_ADMIN);
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
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error(SQL_EXCEPTION); }
        }
        return null;
    }

    public ArrayList<Application> findUserApplications(int userId) {
        try {
            Application application;
            ArrayList<Application> applications = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_APPLICATIONS_OF_USER);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int applicationId = rs.getInt("id_application");
                int vacancyId = rs.getInt("id_vacancy");
                String position = rs.getString("position");
                String status = rs.getString("value");

                application = new Application.ApplicationBuilder().applicationId(applicationId).vacancyId(vacancyId).vacancyPosition(position).status(status).build();
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error(SQL_EXCEPTION); }
        }
        return null;
    }

    public ArrayList<Application> findApplicationsOfVacancy(int vacancyId) {
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
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error(SQL_EXCEPTION); }
        }
        return null;
    }

    public void deleteApplication(int applicationId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_APPLICATION_BY_ID);
            stmt.setInt(1, applicationId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
    }

    public void restoreApplication(int applicationId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_RESTORE_APPLICATION_BY_ID);
            stmt.setInt(1, applicationId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
    }

    public ArrayList<Application> findDeletedApplications() {
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
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error(SQL_EXCEPTION); }
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
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
    }

    public ArrayList<Application> findDeletedApplicationsOfVacancy(Integer vacancyId) {
        try {
            Application application;
            ArrayList<Application> applications = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_DELETED_APPLICATIONS_OF_VACANCY);
            stmt.setInt(1, vacancyId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int applicationId = rs.getInt("id_application");
                String position = rs.getString("position");
                String status = rs.getString("value");

                String name = rs.getString("name");
                String surname = rs.getString("surname");
                boolean deleted = rs.getBoolean("deleted");

                application = new Application.ApplicationBuilder().applicationId(applicationId).applicantName(name)
                        .applicantSurname(surname).vacancyPosition(position).status(status).deleted(deleted).build();
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error(SQL_EXCEPTION); }
        }
        return null;
    }

    public void deleteApplicationsOfVacancy(int vacancyId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_APPLICATIONS_OF_VACANCY);
            stmt.setInt(1, vacancyId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
    }


    public void addApplication(int userId, Integer vacancyId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_PUT_APPLICATION);
            stmt.setInt(1, userId);
            stmt.setInt(2, vacancyId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
    }

    public boolean applicationExistsAndIsActive(int userId, Integer vacancyId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_CHECK_EXISTENCE_AND_ACTIVITY_OF_APPLICATOIN);
            stmt.setInt(1, userId);
            stmt.setInt(2, vacancyId);
            rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
        return false;
    }

    public boolean applicationExists(int userId, Integer vacancyId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_CHECK_EXISTENCE_OF_APPLICATOIN);
            stmt.setInt(1, userId);
            stmt.setInt(2, vacancyId);
            rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
        return false;
    }

    public void restoreApplication(int userId, int vacancyId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_RESTORE_APPLICATION);
            stmt.setInt(1, userId);
            stmt.setInt(2, vacancyId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
    }

    public void deleteApplication(int userId, int vacancyId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_APPLICATION);
            stmt.setInt(1, userId);
            stmt.setInt(2, vacancyId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
    }

    public String getStatusValue(int statusId) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_STATUS_VALUE);
            stmt.setInt(1, statusId);
            rs = stmt.executeQuery();

            if (rs.next()){
                return rs.getString("value");
            }

        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
        return null;
    }

    public ArrayList<Integer> findIdUsersByVacancyId(int vacancyId) {
        ArrayList<Integer> idUsers = new ArrayList<>();
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ID_USERS_BY_VACANCY_ID);
            stmt.setInt(1, vacancyId);
            rs = stmt.executeQuery();

            while (rs.next()){
                int userId = rs.getInt("id_applicant");
                idUsers.add(userId);
            }
            return idUsers;
        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
        }
        return null;
    }

    public ArrayList<Application> findRecruitedUsers() {
        try {
            Application application;
            ArrayList<Application> applications = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_RECRUITED_APPLICATIONS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int applicantId = rs.getInt("id_applicant");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String position = rs.getString("position");
                String status = rs.getString("value");

                application = new Application.ApplicationBuilder().applicantId(applicantId).applicantName(name).applicantSurname(surname).vacancyPosition(position).status(status).build();
                applications.add(application);
            }
            return applications;
        } catch (SQLException e) {
            LOG.error(SQL_EXCEPTION);
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error(SQL_EXCEPTION); }
        }
        return null;
    }
}
