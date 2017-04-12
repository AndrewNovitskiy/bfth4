package com.andrew.dao;

import com.andrew.connection.ConnectionPool;
import com.andrew.entity.User;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.ArrayList;

public class UserDao {

    private static final Logger log = Logger.getLogger(UserDao.class);

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static final String SQL_GET_USER = "SELECT id_applicant, login, password, name, surname, telephone, email FROM applicant WHERE login = ? AND password = ?;";
    private static final String SQL_GET_USER_BY_ID = "SELECT * FROM applicant WHERE id_applicant = ?;";
    private static final String SQL_GET_ALL_USERS = "SELECT * FROM applicant;";
    private static final String SQL_SET_USER = "INSERT INTO applicant (login, password, name, surname, telephone, email) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SQL_CHECK_LOGIN = "SELECT * FROM applicant WHERE login = ?;";
    private static final String SQL_CHECK_USER = "SELECT id_applicant FROM applicant WHERE login = ? AND password = ?;";
    private static final String SQL_GET_RESUME_BY_ID = "SELECT resume FROM applicant WHERE id_applicant = ?;";

    private ConnectionPool pool;

    public UserDao() {
        pool = ConnectionPool.getInstance();
    }

    public User takeUser(String login, String password) {
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
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    public User takeUserById(int userId) {
        User user = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_USER_BY_ID);
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
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    public ArrayList<User> takeAllUsers(){
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
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
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
            log.info("SQLException");
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

            if (rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
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

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return false;
    }

    private void closeResources(Connection conn, PreparedStatement stmt) {
        pool.freeConnection(conn);
        try { stmt.close(); } catch(SQLException se) { log.info("SQLException"); }
    }

    public String takeResume(int userId) {
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
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }
}





























