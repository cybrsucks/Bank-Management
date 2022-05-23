package com.example.work.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("email is already registered");
        }
        userRepository.save(user);
    }

    public void deleteUser(int userId){
        userRepository.findById(userId);
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("user with id " + userId + " does not exist!");
        }
        userRepository.deleteById(userId);
    }
    @Transactional
    public void updateUser(int userId, String username, String email, String password){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user with id " + userId + " does not exist!"));

        if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)){
            user.setUsername(username);
        }

        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional.isPresent()){
                throw new IllegalStateException("email is already registered?");
            }
            user.setEmail(email);
        }

        if (password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }
    }


}
