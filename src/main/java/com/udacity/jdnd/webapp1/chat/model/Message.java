package com.udacity.jdnd.webapp1.chat.model;

public class Message {
  private Integer messageid;
  private String username;
  private String messageText;

  public Integer getMessageid() {
    return messageid;
  }

  public void setMessageid(Integer messageid) {
    this.messageid = messageid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }
}
