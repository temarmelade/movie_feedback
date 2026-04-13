package org.example.movie_feedback.controller;

import lombok.RequiredArgsConstructor;
import org.example.movie_feedback.dto.UserDto;
import org.example.movie_feedback.model.User;
import org.example.movie_feedback.service.UserService;
import org.springframework.http.HttpStatus;
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
    @GetMapping("{userId}")
    public UserDto getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
    @PostMapping
    public HttpStatus createUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return HttpStatus.CREATED;
    }

}
