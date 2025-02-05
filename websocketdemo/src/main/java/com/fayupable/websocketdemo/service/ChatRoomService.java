package com.fayupable.websocketdemo.service;

import com.fayupable.websocketdemo.entity.ChatRoom;
import com.fayupable.websocketdemo.repository.IChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService implements IChatRoomService {

    private final IChatRoomRepository chatRoomRepository;

    @Override
    public Optional<Long> getChatRoomId(
            Long senderId,
            Long recipientId,
            boolean createNewRoomIfNotExists
    ) {
        return chatRoomRepository
                .findBySenderIdAndRecipientId(senderId, recipientId)
                .map(ChatRoom::getChatId)
                .or(() -> {
                    if(createNewRoomIfNotExists) {
                        var chatId = createChatId(senderId, recipientId);
                        return Optional.of(Long.valueOf(chatId));
                    }

                    return  Optional.empty();
                });
    }

    private String createChatId(Long senderId, Long recipientId) {
        var chatId = senderId + "_" + recipientId;

        ChatRoom senderRecipient = ChatRoom
                .builder()
                .chatId(Long.valueOf(chatId))
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom
                .builder()
                .chatId(Long.valueOf(chatId))
                .senderId(recipientId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}