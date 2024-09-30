package com.example.userscrud.service;

import com.example.userscrud.entity.User;
import com.example.userscrud.exception.UserDuplicatedException;
import com.example.userscrud.exception.UserNotFoundException;
import com.example.userscrud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        User user = userRepository.findByEmailAddress(email);
        if (user == null) {
            throw new UserNotFoundException("User with email : " + email + " doesn't exist.");
        }

        return user;
    }

    @Override
    public void deleteUser(String email) {
        User user = userRepository.findByEmailAddress(email);
        userRepository.delete(user);
    }

    @Override
    public void deleteByName(String name) {
        List<User> users = userRepository.findByName(name);
        if (users.size() > 1) {
            throw new UserDuplicatedException("Check users: there are " + users.size() + " users with the same name.");
        } else {
            userRepository.deleteByName(name);
        }

    }

}
