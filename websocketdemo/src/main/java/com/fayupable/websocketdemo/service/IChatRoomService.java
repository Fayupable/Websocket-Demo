package com.fayupable.websocketdemo.service;

import java.util.Optional;

public interface IChatRoomService {
    Optional<Long> getChatRoomId(
            Long senderId,
            Long recipientId,
            boolean createNewRoomIfNotExists
    );
}
