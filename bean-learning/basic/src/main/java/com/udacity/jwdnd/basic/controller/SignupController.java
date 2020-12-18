package com.udacity.jwdnd.basic.controller;

import com.udacity.jwdnd.basic.db.User;
import com.udacity.jwdnd.basic.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private Logger logger = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    UserService userService;

    @GetMapping
    public String signUpView(){
        return "signup";
    }

    @PostMapping
    public String signUp(@ModelAttribute User user, Model model){
        logger.info("**START** signUp User={}", user);
        logger.info("user available ={}", userService.isUserAvailable(user.getUsername()));
        if (userService.isUserAvailable(user.getUsername())) {
            logger.info("Registering User");
            int s = userService.createUser(user);
            logger.info("signup s={}",s);
            if (s >= 0) {
                model.addAttribute("signupSuccess", true);
                return "login";
            } else{
                model.addAttribute("signupSuccess", false);
                model.addAttribute("signupError",
                        "There was some error with user registration");
            }
        } else {
            model.addAttribute("signupSuccess", false);
            model.addAttribute("signupError", "username already exists");
        }
        return "signup";
    }
}
