package com.example.work.user;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    public List<User> getUser() {
        return List.of(new User(1, "username1", "email1@gmail.com", "password1"));
    }
}
