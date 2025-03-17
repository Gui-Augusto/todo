package com.todo.todo.core.user.service;

import com.todo.todo.controller.user.dto.UserDTO;
import com.todo.todo.core.user.User;
import com.todo.todo.repository.user.IUserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepository IUserRepository;

    public void addUser(String userName) {
        User user = new User(userName);
        IUserRepository.insert(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = IUserRepository.findAll();
        return users.stream().map(user -> UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .build()).toList();
    }
}
