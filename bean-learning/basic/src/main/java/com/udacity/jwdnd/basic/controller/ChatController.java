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
    public String getChats(@ModelAttribute("userProfile") ChatFormPojo userProfile,Model model) {
        logger.info("**START** getChats");
//        logger.info("getChats {}", chatMessageService.getChatMessages());
        model.addAttribute("chatMessages", chatMessageService.getChatMessages());
        logger.info("**END** getChats {}", this.chatMessageService.getChatMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String postChats(Authentication auth, @ModelAttribute("userProfile") ChatFormPojo userProfile, Model model) {
        logger.info("*** START postChats userProfile = {}", userProfile);
        logger.info("auth {}", auth.getName());
        userProfile.setUsername(auth.getName());
        logger.info("{}", userProfile);
        this.chatMessageService.addMessages(userProfile);
        model.addAttribute("chatMessages", this.chatMessageService.getChatMessages());

        logger.info("*** END postChats {}", this.chatMessageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] getAllMessageTypes() {
        return new String[] {"Say", "SHOUT", "whisper"};
    }
}
