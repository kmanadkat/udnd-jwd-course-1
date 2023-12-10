package com.udacity.jdnd.webapp1.chat.mapper;

import com.udacity.jdnd.webapp1.chat.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM MESSAGES")
    List<Message> getAllMessages();

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int addMessage(Message message);
}