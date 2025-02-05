package com.fayupable.websocketdemo.service;

import com.fayupable.websocketdemo.Enum.Status;
import com.fayupable.websocketdemo.entity.User;
import com.fayupable.websocketdemo.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Override
    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    @Override
    public void disconnectUser(User user) {
        var storedUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        }
    }

    @Override
    public List<User> findConnectedUsers() {
        return userRepository.finAllByStatus(Status.ONLINE);
    }
}
