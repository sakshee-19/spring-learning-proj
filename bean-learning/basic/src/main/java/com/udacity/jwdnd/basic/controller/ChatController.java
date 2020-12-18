package com.udacity.jwdnd.basic.controller;

import com.udacity.jwdnd.basic.chats.ChatFormPojo;
import com.udacity.jwdnd.basic.services.MessageService;
import com.udacity.jwdnd.basic.db.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {

    private Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    MessageService chatMessageService;

    @GetMapping("/chat")
    public String getChats(Model model) {
        logger.info("**START** getChats");
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.info("getChats {}", chatMessageService.getChatMessagesByUser(user));
        model.addAttribute("chatMessages", this.chatMessageService.getChatMessagesByUser(user));
        logger.info("**END** getChats");
        return "chat";
    }

    @PostMapping("/chat")
    public String postChats(@ModelAttribute("userProfile") ChatFormPojo userProfile, Model model) {
        logger.info("*** START postChats userProfile = {}", userProfile);
        ChatMessage cm = new ChatMessage();
        switch (userProfile.getMessageType()){
            case "Say":
                cm.setMessageText(userProfile.getMessageText());
                break;
            case "whisper":
                cm.setMessageText(userProfile.getMessageText().toLowerCase());
                break;
            case "SHOUT":
                cm.setMessageText(userProfile.getMessageText().toUpperCase());
                break;
        }
//        cm.setUsername(userProfile.getUsername());
        logger.info("auth {}", SecurityContextHolder.getContext().getAuthentication().getName());
        cm.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        logger.info("{}", userProfile);
        this.chatMessageService.addMessages(cm);
        model.addAttribute("chatMessages", this.chatMessageService.getChatMessages());

        logger.info("*** END postChats");
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] getAllMessageTypes() {
        return new String[] {"Say", "SHOUT", "whisper"};
    }
}
