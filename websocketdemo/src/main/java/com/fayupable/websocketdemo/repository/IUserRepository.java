package com.fayupable.websocketdemo.repository;

import com.fayupable.websocketdemo.Enum.Status;
import com.fayupable.websocketdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> finAllByStatus(Status status);
}
