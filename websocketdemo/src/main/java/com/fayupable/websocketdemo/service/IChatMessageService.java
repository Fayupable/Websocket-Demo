package com.fayupable.websocketdemo.service;

import com.fayupable.websocketdemo.entity.ChatMessage;

import java.util.List;

public interface IChatMessageService {
    ChatMessage save(ChatMessage chatMessage);

    List<ChatMessage> findChatMessages(Long senderId, Long recipientId);
}
