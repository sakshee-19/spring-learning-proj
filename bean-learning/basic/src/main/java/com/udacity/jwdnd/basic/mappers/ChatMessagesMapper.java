package com.udacity.jwdnd.basic.mappers;

import com.udacity.jwdnd.basic.db.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatMessagesMapper {

    @Select("SELECT * FROM MESSAGES where username=#{username}")
    List<ChatMessage> findMessagesByUsername(String username);

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> findAllMessages();

    @Insert("INSERT into MESSAGES (message_text, username) values (#{messageText}, #{username} )")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int addNewChatMessage(ChatMessage message);

    @Delete("DELETE FROM MESSAGES WHERE message_id=#{id}")
    void deleteMessage(String id);
}
