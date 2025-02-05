package com.fayupable.websocketdemo.service;

import com.fayupable.websocketdemo.entity.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);

    void disconnectUser(User user);

    List<User> findConnectedUsers();
}
