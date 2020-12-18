package com.udacity.jwdnd.basic.db;

public class ChatMessage {

    private String username;
    private String messageText;
    private Integer messageId;

    public Integer getMessageId() {
        return messageId;
    }
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "username='" + username + '\'' +
                ", messageText='" + messageText + '\'' +
                ", messageId=" + messageId +
                '}';
    }
}
