package com.udacity.jdnd.webapp1.chat;

import java.util.ArrayList;
import java.util.List;

import com.udacity.jdnd.webapp1.chat.model.Message;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class ChatService {
  private List<Message> messages;

  @PostConstruct
  public void postConstruct() {
    this.messages = new ArrayList<>();
  }

  public void addNewMessage(Message message) {
    this.messages.add(message);
  }

  public List<Message> getAllMessages() {
    return new ArrayList<>(this.messages);
  }
}
