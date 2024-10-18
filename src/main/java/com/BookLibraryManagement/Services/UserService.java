package com.BookLibraryManagement.Services;

import com.BookLibraryManagement.Entities.User;
import com.BookLibraryManagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User userFindById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
