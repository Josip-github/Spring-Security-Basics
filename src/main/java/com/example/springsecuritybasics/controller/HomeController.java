package com.example.springsecuritybasics.controller;

import com.example.springsecuritybasics.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }
}
