package com.example.springsecuritybasics.controller;

import com.example.springsecuritybasics.model.MessageForm;
import com.example.springsecuritybasics.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String getHomePage(MessageForm messageForm, Model model){
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping
    public String addMessage(MessageForm messageForm, Model model){
        this.messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", this.messageListService.getMessages());
        messageForm.setText("");
        return "home";
    }
}
