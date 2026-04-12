package org.example.movie_feedback.service;

import org.example.movie_feedback.dto.UserDto;


import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
