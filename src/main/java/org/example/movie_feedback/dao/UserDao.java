package org.example.movie_feedback.dao;

import lombok.RequiredArgsConstructor;
import org.example.movie_feedback.dao.mapper.UserMapper;
import org.example.movie_feedback.dto.UserDto;
import org.example.movie_feedback.model.User;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    public List<User> getUsers() {
        String query = "select * from users";
        return jdbcTemplate.query(query, new UserMapper());
    }
    public Optional<User>  getUserById(int id) {
        String query = "select * from users where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(query, new UserMapper(), id)
                )
        );
    }
    public void create(User user) {
        String sql = "insert into users(name, password)" + "values(:name, :password)";
        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource()
                        .addValue("name", user.getName())
                        .addValue("password", user.getPassword())
        );
    }
    public int createAndReturnId(User user) {
        String sql = "insert into users(name, password)" + "values(?, ?)";
        jdbcTemplate.update(con ->  {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }
}
