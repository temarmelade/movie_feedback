package org.example.movie_feedback.service.implementations;

import lombok.RequiredArgsConstructor;
import org.example.movie_feedback.dao.UserDao;
import org.example.movie_feedback.dto.UserDto;
import org.example.movie_feedback.model.User;
import org.example.movie_feedback.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Override
    public List<UserDto> getUsers() {
        List<User> list = userDao.getUsers();
        return list.stream()
                .map(e -> UserDto.builder()
                        .id(e.getId())
                        .name(e.getName())
                        .password(e.getPassword())
                        .build())
                .toList();
    }
}
