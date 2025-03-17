package com.todo.todo.core.user;

import com.todo.todo.controller.user.dto.UserDTO;
import com.todo.todo.core.user.service.UserService;
import com.todo.todo.repository.user.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    IUserRepository repository;

    @InjectMocks
    UserService userService;

    @Test
    void testAddUser() {
        String userName = "testUser";
        userService.addUser(userName);

        Mockito.verify(repository).insert(new User(userName));
    }

    @Test
    void testGetAllUsers() {
        List<User> users = new ArrayList();
        users.add(new User("User1"));
        users.add(new User("User2"));

        when(repository.findAll()).thenReturn(users);

        List<UserDTO> userDTOs = userService.getAllUsers();

        assertEquals(2, userDTOs.size());
        assertEquals("User1", userDTOs.get(0).getName());
        assertEquals("User2", userDTOs.get(1).getName());
    }
}
