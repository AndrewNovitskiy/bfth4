package com.andrew.entity;

import java.sql.Timestamp;

/**
 * Created by Andrew on 02.04.2017.
 */
public class Message {
    private int messageId;
    private int recipientId;
    private int senderId;
    private String title;
    private String content;
    private Timestamp dateTime;
    private String recipientName;
    private String recipientSurname;

    public Message(int messageId, int recipientId, int senderId, String title, String content, Timestamp dateTime) {
        this.messageId = messageId;
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Message(int messageId, int recipientId, String recipientName, String recipientSurname, int senderId, String title, String content, Timestamp dateTime) {
        this.messageId = messageId;
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.senderId = senderId;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
        this.recipientId = recipientId;
    }

    public Message(int messageId, String recipientName, String recipientSurname, int senderId, String title, String content, Timestamp dateTime) {
        this.messageId = messageId;
        this.recipientName = recipientName;
        this.recipientSurname = recipientSurname;
        this.senderId = senderId;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;

    }

    public Message(int recipientId, int senderId, String title, String content, Timestamp dateTime) {
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public void setRecipientSurname(String recipientSurname) {
        this.recipientSurname = recipientSurname;
    }
}
