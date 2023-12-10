package com.udacity.jdnd.webapp1.chat.service;

import com.udacity.jdnd.webapp1.chat.mapper.MessageMapper;
import com.udacity.jdnd.webapp1.chat.model.Message;
import com.udacity.jdnd.webapp1.chat.model.MessageForm;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper){
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

    public void addMessage(MessageForm messageForm) {
        Message newMessage = new Message();
        newMessage.setUsername(messageForm.getUsername());
        newMessage.setMessageText(messageForm.getMessageText());
        messageMapper.addMessage(newMessage);
    }

    public List<Message> getAllMessages() {
        return messageMapper.getAllMessages();
    }
}
