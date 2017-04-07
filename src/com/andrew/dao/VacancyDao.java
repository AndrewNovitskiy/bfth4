package com.andrew.dao;

import com.andrew.connection.ConnectionPool;
import com.andrew.entity.Vacancy;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Andrew on 02.04.2017.
 */
public class VacancyDao {

    private static final Logger LOG = Logger.getLogger(VacancyDao.class);

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;


    private static final String SQL_GET_ALL_VACANCIES = "SELECT * FROM vacancy;";
    private static final String SQL_GET_VACANCY_BY_ID = "SELECT * FROM vacancy WHERE id_vacancy = ?;";

    private ConnectionPool pool;

    public VacancyDao() {
        pool = ConnectionPool.getInstance();
    }

    public ArrayList<Vacancy> takeAllVacancies(){
        try {
            Vacancy vacancy;
            ArrayList<Vacancy> vacancies = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ALL_VACANCIES);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int vacancyId = rs.getInt("id_vacancy");
                Timestamp dateTime = rs.getTimestamp("date_time");
                String position = rs.getString("position");
                int experience = rs.getInt("experience");
                int salary = rs.getInt("salary");
                //String info = rs.getString("info");
                vacancy = new Vacancy(vacancyId, dateTime, position, experience, salary);
                vacancies.add(vacancy);
            }
            return vacancies;
        } catch (SQLException e) {
            LOG.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.info("SQLException"); }
        }
        return null;
    }

    public Vacancy takeVacancyById(int vacancyId){
        try {
            Vacancy vacancy = null;
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_VACANCY_BY_ID);
            stmt.setInt(1, vacancyId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Timestamp dateTime = rs.getTimestamp("date_time");
                String position = rs.getString("position");
                int experience = rs.getInt("experience");
                int salary = rs.getInt("salary");
                String info = rs.getString("info");
                vacancy = new Vacancy(vacancyId, dateTime, position, experience, salary, info);
            }
            return vacancy;
        } catch (SQLException e) {
            LOG.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.info("SQLException"); }
        }
        return null;
    }


    private void closeResources(Connection conn, PreparedStatement stmt) {
        pool.freeConnection(conn);
        try { stmt.close(); } catch(SQLException se) { LOG.info("SQLException"); }
    }
}
