package com.andrew.dao;

import com.andrew.connection.ConnectionPool;
import com.andrew.entity.Message;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Andrew on 02.04.2017.
 */
public class MessageDao {
    private static final Logger LOG = Logger.getLogger(MessageDao.class);

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;


    private static final String SQL_GET_ALL_ADMIN_MESSAGES = "SELECT message.id_message, applicant.name, applicant.surname, message.id_sender, message.title, message.content, message.date_time\n" +
            "\tFROM message LEFT JOIN applicant ON message.id_recipient = applicant.id_applicant\n" +
            "    WHERE id_sender = ?;";
    private static final String SQL_GET_ADMIN_MESSAGE_BY_ID = "SELECT message.id_message, applicant.name, applicant.surname, message.id_sender, message.id_recipient, message.title, message.content, message.date_time FROM message LEFT JOIN applicant ON message.id_recipient = applicant.id_applicant WHERE id_message = ? AND id_sender = ?;";
    private static final String SQL_CHECK_MESSAGE = "SELECT id_message FROM message WHERE id_message = ? AND id_sender = ?;";
    private static final String SQL_GET_MESSAGES_FOR_USER = "SELECT message.id_message, applicant.name, applicant.surname, message.id_sender, message.title, message.content, message.date_time\n" +
            "\tFROM message LEFT JOIN applicant ON message.id_recipient = applicant.id_applicant\n" +
            "    WHERE id_sender = ? AND id_recipient = ?;";


    private static final String SQL_PUT_MESSAGE = "INSERT INTO message (id_message, id_recipient, id_sender, title, content, date_time) \n" +
            "\tVALUES (NULL, ?, ?, ?, ?, current_timestamp());";


    private ConnectionPool pool;

    public MessageDao() {
        pool = ConnectionPool.getInstance();
    }

    public ArrayList<Message> takeAllAdminMessages(int adminId){
        try {
            Message message;
            ArrayList<Message> messages = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ALL_ADMIN_MESSAGES);
            stmt.setInt(1, adminId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int messageId = rs.getInt("id_message");
                String recipientName = rs.getString("name");
                String recipientSurname = rs.getString("surname");
                int senderId = rs.getInt("id_sender");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Timestamp dateTime = rs.getTimestamp("date_time");


                //message = new Message(messageId, recipientName, recipientSurname, senderId, title, content, dateTime);
                message = new Message.MessageBuilder().messageId(messageId).recipientName(recipientName)
                        .recipientSurname(recipientSurname).senderId(senderId).title(title).content(content)
                        .dateTime(dateTime).build();
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            LOG.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.info("SQLException"); }
        }
        return null;
    }



    public Message takeMessageById(int messageId, int adminId){
        try {
            Message message = null;
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ADMIN_MESSAGE_BY_ID);
            stmt.setInt(1, messageId);
            stmt.setInt(2, adminId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                int senderId = rs.getInt("id_sender");
                int recipientId = rs.getInt("id_recipient");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Timestamp dateTime = rs.getTimestamp("date_time");
                String recipientName = rs.getString("name");
                String recipientSurname = rs.getString("surname");

                //message = new Message(messageId, recipientId, recipientName, recipientSurname,  senderId, title, content, dateTime);
                message = new Message.MessageBuilder().messageId(messageId).recipientId(recipientId)
                        .recipientName(recipientName).recipientSurname(recipientSurname).senderId(senderId)
                        .title(title).content(content).dateTime(dateTime).build();
            }
            return message;
        } catch (SQLException e) {
            LOG.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.info("SQLException"); }
        }
        return null;
    }


    public boolean checkMessage(int messageId, int adminId){
        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_CHECK_MESSAGE);
            stmt.setInt(1, messageId);
            stmt.setInt(2, adminId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            LOG.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.info("SQLException"); }
        }
        return false;
    }

    private void closeResources(Connection conn, PreparedStatement stmt) {
        pool.freeConnection(conn);
        try { stmt.close(); } catch(SQLException se) { LOG.info("SQLException"); }
    }

    public ArrayList<Message> takeMessagesForUser(int adminId, Integer userId) {
        try {
            Message message;
            ArrayList<Message> messages = new ArrayList<>();
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_GET_MESSAGES_FOR_USER);
            stmt.setInt(1, adminId);
            stmt.setInt(2, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int messageId = rs.getInt("id_message");
                String recipientName = rs.getString("name");
                String recipientSurname = rs.getString("surname");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Timestamp dateTime = rs.getTimestamp("date_time");


                //message = new Message(messageId, recipientName, recipientSurname, adminId, title, content, dateTime);
                message = new Message.MessageBuilder().messageId(messageId).recipientName(recipientName)
                        .recipientSurname(recipientSurname).senderId(adminId).title(title).content(content)
                        .dateTime(dateTime).build();
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            LOG.info("SQLException");
        } finally {
            closeResources(conn, stmt);
            try { rs.close(); } catch(SQLException se) { LOG.info("SQLException"); }
        }
        return null;
    }

    public void putMessage(int adminId, Integer recipientId, String title, String content) {

        try {
            conn = pool.getConnection();
            stmt = conn.prepareStatement(SQL_PUT_MESSAGE);
            stmt.setInt(1, recipientId);
            stmt.setInt(2, adminId);
            stmt.setString(3, title);
            stmt.setString(4, content);
            stmt.executeUpdate();

        } catch (SQLException e) {
            LOG.info("SQLException");
        } finally {
            closeResources(conn, stmt);
        }

    }
}
