package com.udacity.jwdnd.basic;

import com.udacity.jwdnd.basic.chats.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageService {

    private String message;

    private List<ChatMessage> chatMessages;

    public MessageService(String message){
        this.message = message;
    }

    public String upperCase() {
        return this.message.toUpperCase();
    }

    public String lowerCase() {
        return this.message.toLowerCase();
    }

    public void addMessages(ChatMessage chatMessage) {
        if(this.chatMessages == null) this.chatMessages = new ArrayList<>();
        this.chatMessages.add(chatMessage);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("creating message service bean");
    }

    public List<ChatMessage> getChatMessages() {
        if(this.chatMessages == null)
            this.chatMessages = new ArrayList<>();
        return this.chatMessages;
    }
}
