package com.udacity.jwdnd.basic.chats;


public class ChatFormPojo {

    private String username;
    private String messageText;
    private String messageType;

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

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "ChatFormPojo{" +
                "username='" + username + '\'' +
                ", messageText='" + messageText + '\'' +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
