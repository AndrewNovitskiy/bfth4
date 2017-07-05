package com.andrew.dao;

import com.andrew.entity.User;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao extends Dao {

    private static final Logger LOG = Logger.getLogger(UserDao.class);

    private static final String SQL_GET_USER = "SELECT id_applicant, login, password, name, surname, telephone, email FROM applicant WHERE login = ? AND password = ?;";
    private static final String SQL_GET_USER_INFO_BY_ID = "SELECT * FROM applicant WHERE id_applicant = ?;";
    private static final String SQL_GET_ALL_USERS = "SELECT * FROM applicant;";
    private static final String SQL_SET_USER = "INSERT INTO applicant (login, password, name, surname, telephone, email) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SQL_CHECK_LOGIN = "SELECT * FROM applicant WHERE login = ?;";
    private static final String SQL_CHECK_USER = "SELECT id_applicant FROM applicant WHERE login = ? AND password = ?;";
    private static final String SQL_GET_RESUME_BY_ID = "SELECT resume FROM applicant WHERE id_applicant = ?;";
    private static final String SQL_UPDATE_USER = "UPDATE applicant SET applicant.name = ?, applicant.surname = ?, applicant.telephone = ?, applicant.email = ?, applicant.resume = ? WHERE applicant.id_applicant = ?;";
    private static final String SQL_GET_USER_BY_ID = "SELECT id_applicant, login, password, name, surname, telephone, email FROM applicant WHERE id_applicant = ?;";
    private static final String SQL_CHANGE_USER_PWD = "UPDATE applicant SET applicant.password = ? WHERE applicant.id_applicant = ?;";
    private static final String SQL_DELETE_USER_PWD = "DELETE QUICK FROM applicant WHERE applicant.login = ?;";


    public User findUser(String login, String password) {
        User user = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_USER);
            stmt.setString(1, login);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id_applicant");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");
                String userName = rs.getString("name");
                String userSurname = rs.getString("surname");
                String userTelephone = rs.getString("telephone");
                String userEmail = rs.getString("email");

                user = new User.UserBuilder().idApplicant(userId).login(userLogin).password(userPassword)
                        .name(userName).surname(userSurname).telephone(userTelephone).email(userEmail).build();
            }
            return user;
        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQL Exception"); }
        }
        return null;
    }

    public User findUserInfoById(int userId) {
        User user = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_USER_INFO_BY_ID);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String userLogin = rs.getString("login");
                String userName = rs.getString("name");
                String userSurname = rs.getString("surname");
                String userTelephone = rs.getString("telephone");
                String userEmail = rs.getString("email");
                String userResume = rs.getString("resume");

                user = new User.UserBuilder().login(userLogin)
                        .name(userName).surname(userSurname).telephone(userTelephone).email(userEmail)
                        .resume(userResume).idApplicant(userId).build();
            }
            return user;
        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQL Exception"); }
        }
        return null;
    }

    public ArrayList<User> findAllUsers(){
        try {
            User user;
            ArrayList<User> users = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ALL_USERS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int userId = rs.getInt("id_applicant");
                String userLogin = rs.getString("login");
                String userName = rs.getString("name");
                String userSurname = rs.getString("surname");
                String userTelephone = rs.getString("telephone");
                String userEmail = rs.getString("email");

                user = new User.UserBuilder().idApplicant(userId).login(userLogin).name(userName)
                        .surname(userSurname).telephone(userTelephone).email(userEmail).build();

                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQL Exception"); }
        }
        return null;
    }


    public void addUser(String login, String password, String name, String surname, String telephone, String email) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_SET_USER);
            stmt.setString(1, login);
            stmt.setString(2, password);
            stmt.setString(3, name);
            stmt.setString(4, surname);
            stmt.setString(5, telephone);
            stmt.setString(6, email);

            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
        }
    }

    public boolean checkLogin(String login) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_CHECK_LOGIN);
            stmt.setString(1, login);
            rs = stmt.executeQuery();

            return !rs.next();
        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQL Exception"); }
        }
        return false;
    }


    public boolean checkUser(String login, String password) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_CHECK_USER);
            stmt.setString(1, login);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQL Exception"); }
        }
        return false;
    }



    public String findResume(int userId) {
        String resume = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_RESUME_BY_ID);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                resume = rs.getString("resume");
            }
            return resume;
        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQL Exception"); }
        }
        return null;
    }

    public void updateUser(int idApplicant, String name, String surname, String telephone, String email, String resume) {

        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_USER);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, telephone);
            stmt.setString(4, email);
            stmt.setString(5, resume);
            stmt.setInt(6, idApplicant);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
        }

    }

    public User findUserById(int applicantId) {
        User user = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_USER_BY_ID);
            stmt.setInt(1, applicantId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id_applicant");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");
                String userName = rs.getString("name");
                String userSurname = rs.getString("surname");
                String userTelephone = rs.getString("telephone");
                String userEmail = rs.getString("email");

                user = new User.UserBuilder().idApplicant(userId).login(userLogin).password(userPassword)
                        .name(userName).surname(userSurname).telephone(userTelephone).email(userEmail).build();
            }
            return user;
        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQL Exception"); }
        }
        return null;
    }

    public void changeUserPassword(int applicantId, String newPassword) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_CHANGE_USER_PWD);
            stmt.setString(1, newPassword);
            stmt.setInt(2, applicantId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
        }
    }

    public void deleteUser(String login) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_USER_PWD);
            stmt.setString(1, login);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.error("SQL Exception");
        } finally {
            closeResources(conn, stmt);
        }
    }
}





























