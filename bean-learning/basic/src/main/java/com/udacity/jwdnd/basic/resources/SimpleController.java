package com.udacity.jwdnd.basic.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

    public boolean firstVisit = true;

    @RequestMapping("/simplehome")
    public String simpleHome(Model model) {
        model.addAttribute("firstVisit", firstVisit);
        firstVisit = false;
        return "simple-home";
    }
}
