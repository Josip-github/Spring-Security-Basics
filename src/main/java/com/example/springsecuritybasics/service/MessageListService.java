package com.example.springsecuritybasics.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {

    private List<String> messages;

    public MessageListService(List<String> messages) {
        this.messages = messages;
    }

    public void addMessage(String message){
        messages.add(message);
    }

    public List<String> getMessages(){
        return new ArrayList<>(this.messages);
    }
}
