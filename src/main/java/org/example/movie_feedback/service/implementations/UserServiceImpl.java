package org.example.movie_feedback.service.implementations;

import lombok.RequiredArgsConstructor;
import org.example.movie_feedback.dao.UserDao;
import org.example.movie_feedback.dto.UserDto;
import org.example.movie_feedback.exceptions.UserNotFoundException;
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

    @Override
    public UserDto getUserById(int id) {
        User user = userDao.getUserById(id)
                .orElseThrow(UserNotFoundException::new);
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }

    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        userDao.create(user);
    }

    @Override
    public int createUserAndReturnId(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return userDao.createAndReturnId(user);
    }
}
