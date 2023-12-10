package com.udacity.jdnd.webapp1.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;

@Controller
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService){
        this.messageListService = messageListService;
    }

    @GetMapping("/home")
    public String getHomePage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("authorName", "Krupesh");
        model.addAttribute("timeInstance", Instant.now().toString());
        model.addAttribute("pages", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        model.addAttribute("authorName", "Krupesh");
        model.addAttribute("timeInstance", Instant.now().toString());

        messageListService.addMessage(newMessage.getText());
        model.addAttribute("pages", this.messageListService.getMessages());
        return "home";
    }
}
