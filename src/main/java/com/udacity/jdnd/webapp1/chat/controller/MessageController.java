package com.udacity.jdnd.webapp1.chat.controller;

import com.udacity.jdnd.webapp1.chat.model.MessageForm;
import com.udacity.jdnd.webapp1.chat.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChatPage(MessageForm messageForm, Model model) {
        model.addAttribute("messages", this.messageService.getAllMessages());
        return "chat";
    }

    @PostMapping
    public String postChatMessage(Authentication authentication, MessageForm messageForm, Model model) {
        messageForm.setUsername(authentication.getName());
        this.messageService.addMessage(messageForm);
        messageForm.setMessageText("");
        model.addAttribute("messages", this.messageService.getAllMessages());
        return "chat";
    }
}
