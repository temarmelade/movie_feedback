package org.example.movie_feedback.controller;

import lombok.RequiredArgsConstructor;
import org.example.movie_feedback.dto.UserDto;
import org.example.movie_feedback.model.User;
import org.example.movie_feedback.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }
    @PostMapping
    public Optional<UserDto> createUser(@RequestBody UserDto userDto) {
        return null;
    };
}
