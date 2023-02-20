package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    // Query the session list of the current user, and return only one piece of latest data for each session
    List<Message> selectConversations(int userId, int offset, int limit);

    // Query the number of sessions of the current user
    int selectConversationCount(int userId);

    // Query the list of private messages contained in a session
    List<Message> selectLetters(String conversationId, int offset, int limit);

    // Query the number of private messages contained in a session
    int selectLetterCount(String conversationId);

    // Query the number of unread private messages
    int selectLetterUnreadCount(int userId, String conversationId);

    // new message
    int insertMessage(Message message);

    // Modify the status of the message
    int updateStatus(List<Integer> ids, int status);

    // Query the latest notifications under a topic
    Message selectLatestNotice(int userId, String topic);

    // Query the number of notifications contained in a topic
    int selectNoticeCount(int userId, String topic);

    // Query the number of unread notifications
    int selectNoticeUnreadCount(int userId, String topic);

    // Query the list of notifications contained in a topic
    List<Message> selectNotices(int userId, String topic, int offset, int limit);
}
