package com.udacity.jwdnd.basic.chats;

import com.udacity.jwdnd.basic.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    @Autowired
    MessageService chatMessageService;

    @GetMapping("/chat")
    public String getChats(@ModelAttribute("userProfile") ChatFormPojo userProfile, Model model) {
        System.out.println(this.chatMessageService.getChatMessages());
        model.addAttribute("chatMessages", this.chatMessageService.getChatMessages());
        return "chat";
    }


    @PostMapping("/chat")
    public String postChats(@ModelAttribute("userProfile") ChatFormPojo userProfile, Model model) {
        System.out.println("sakju "+userProfile);
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
        cm.setUsername(userProfile.getUsername());
        this.chatMessageService.addMessages(cm);
        model.addAttribute("chatMessages", this.chatMessageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] getAllMessageTypes() {
        return new String[] {"Say", "SHOUT", "whisper"};
    }
}
