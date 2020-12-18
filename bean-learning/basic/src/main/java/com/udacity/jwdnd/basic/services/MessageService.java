package com.udacity.jwdnd.basic.services;

import com.udacity.jwdnd.basic.db.ChatMessage;
import com.udacity.jwdnd.basic.mappers.ChatMessagesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageService {

    @Autowired
    private ChatMessagesMapper messagesMapper;

    private String message;

    private Logger logger = LoggerFactory.getLogger(MessageService.class);

//    private List<ChatMessage> chatMessages;

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
        logger.info("**START** addMessages chatMessage={}", chatMessage);
//        if(this.chatMessages == null) this.chatMessages = new ArrayList<>();
        messagesMapper.addNewChatMessage(chatMessage);
//        this.chatMessages.add(chatMessage);
        logger.info("**END** addMessages ");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("creating message service bean");
    }

    public List<ChatMessage> getChatMessages() {
//        if(this.chatMessages == null)
//            this.chatMessages = new ArrayList<>();
        logger.info("**START** getChatMessages ");
        return messagesMapper.findAllMessages();
    }

    public List<ChatMessage> getChatMessagesByUser(String username) {
        logger.info("**START** getChatMessagesByUser username={} ", username);
        return messagesMapper.findMessagesByUsername(username);
    }
}
