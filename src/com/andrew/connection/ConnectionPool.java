package com.andrew.connection;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOG = Logger.getLogger(ConnectionPool.class);

    private static Semaphore semaphore;
    private static Lock lock = new ReentrantLock();
    private static Queue<Connection> connections;
    private static ConnectionPool instance;

    private String url;
    private String user;
    private String password;


    private ConnectionPool() {
        try {
            Properties prop = new Properties();
            InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream("/db.properties");
            prop.load(inputStream);

            int poolSize = Integer.parseInt(prop.getProperty("limit"));
            semaphore = new Semaphore(poolSize, true);
            connections = new LinkedList<>();

            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
        } catch (FileNotFoundException e) {
            LOG.error("DB properties not found");
        } catch (IOException e) {
            LOG.error("can't load DB properties");
        }
    }

    public static ConnectionPool getInstance() {
        lock.lock();
        try {
            if(instance == null) {
                instance = new ConnectionPool();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }


    public Connection getConnection() {
        Connection connection = null;
        try {
            if(semaphore.tryAcquire(10, TimeUnit.SECONDS)) {
                lock.lock();
                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    connection = connections.isEmpty() ? DriverManager.getConnection(url, user, password) :
                        connections.poll();
                } catch (SQLException e) {
                    LOG.error("SQL Exception");
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            LOG.error("Interrupted Exception");
        }

        return connection;
    }

    public void freeConnection(Connection connection) {
        lock.lock();
        try {
            connections.add(connection);
            semaphore.release();
        } finally {
            lock.unlock();
        }
    }
}
