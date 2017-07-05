package com.andrew.dao;

import com.andrew.connection.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrew on 02.05.2017.
 */
abstract class Dao {
    private static final Logger LOG = Logger.getLogger(Dao.class);

    protected ConnectionPool pool;
    protected Connection conn;
    PreparedStatement stmt;
    ResultSet rs;

    Dao() {
        pool = ConnectionPool.getInstance();
    }

    void closeResources(Connection conn, PreparedStatement stmt) {
        pool.freeConnection(conn);
        try {
            stmt.close();
        } catch(SQLException se) {
            LOG.error("SQL Exception");
        }
    }

}
