package com.fayupable.websocketdemo.entity;

import com.fayupable.websocketdemo.Enum.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String fullName;
    private Status status;
}
