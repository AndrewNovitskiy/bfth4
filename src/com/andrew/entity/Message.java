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
    private String senderLogin;


    public Message(MessageBuilder builder) {
        this.messageId = builder.messageId;
        this.recipientId = builder.recipientId;
        this.senderId = builder.senderId;
        this.title = builder.title;
        this.content = builder.content;
        this.dateTime = builder.dateTime;
        this.recipientName = builder.recipientName;
        this.recipientSurname = builder.recipientSurname;
        this.senderLogin = builder.senderLogin;
    }

    public static class MessageBuilder {
        private int messageId;
        private int recipientId;
        private int senderId;
        private String title;
        private String content;
        private Timestamp dateTime;
        private String recipientName;
        private String recipientSurname;
        private String senderLogin;

        public MessageBuilder(){}

        public MessageBuilder messageId(int val) {
            messageId = val;
            return this;
        }

        public MessageBuilder recipientId(int val) {
            recipientId = val;
            return this;
        }

        public MessageBuilder senderId(int val) {
            senderId = val;
            return this;
        }

        public MessageBuilder title(String val) {
            title = val;
            return this;
        }

        public MessageBuilder content(String val) {
            content = val;
            return this;
        }

        public MessageBuilder dateTime(Timestamp val) {
            dateTime = val;
            return this;
        }

        public MessageBuilder recipientName(String val) {
            recipientName = val;
            return this;
        }

        public MessageBuilder recipientSurname(String val) {
            recipientSurname = val;
            return this;
        }

        public MessageBuilder senderLogin(String val) {
            senderLogin = val;
            return this;
        }

        public Message build() {
            return new Message(this);
        }

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

    public String getSenderLogin() {
        return senderLogin;
    }

    public void setSenderLogin(String senderLogin) {
        this.senderLogin = senderLogin;
    }
}
