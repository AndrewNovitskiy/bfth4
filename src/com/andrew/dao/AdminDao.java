package com.andrew.dao;

import com.andrew.entity.Admin;
import org.apache.log4j.Logger;

import java.sql.SQLException;


public class AdminDao extends Dao {
    private static final Logger LOG = Logger.getLogger(AdminDao.class);

    private static final String SQL_GET_ADMIN = "SELECT id_admin, login, password FROM admin WHERE login = ? AND password = ?;";
    private static final String SQL_CHECK_ADMIN = "SELECT id_admin FROM admin WHERE login = ? AND password = ?;";


    public Admin findAdmin(String login, String password) {
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
            LOG.error("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQLException"); }
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
            LOG.error("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.error("SQLException"); }
        }
        return false;
    }


}
