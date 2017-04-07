package com.andrew.dao;

import com.andrew.connection.ConnectionPool;
import com.andrew.entity.Admin;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDao {
    private static final Logger log = Logger.getLogger(AdminDao.class);

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private static final String SQL_GET_ADMIN = "SELECT id_admin, login, password FROM admin WHERE login = ? AND password = ?;";
    private static final String SQL_CHECK_ADMIN = "SELECT id_admin FROM admin WHERE login = ? AND password = ?;";

    private ConnectionPool pool;

    public AdminDao() {
        pool = ConnectionPool.getInstance();
    }

    public Admin takeAdmin(String login, String password) {
        Admin admin = null;
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ADMIN);
            stmt.setString(1, login);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int adminId = rs.getInt("id_admin");
                String adminLogin = rs.getString("login");
                String adminPassword = rs.getString("password");

                admin = new Admin(adminId, adminLogin, adminPassword);
            }
            return admin;
        } catch (SQLException e) {
            log.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { log.info("SQLException"); }
        }
        return null;
    }

    public boolean checkAdmin(String login, String password) {
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_CHECK_ADMIN);
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
}
