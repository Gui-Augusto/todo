package com.todo.todo.controller.user;

import com.todo.todo.controller.user.dto.UserDTO;
import com.todo.todo.core.user.User;
import com.todo.todo.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserDTO>> findUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/addUser/{nome}")
    public ResponseEntity<Void> addUser(@PathVariable String nome) {
        userService.addUser(nome);
        return ResponseEntity.ok().build();
    }
}
