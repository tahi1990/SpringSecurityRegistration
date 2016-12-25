package com.spring.sample.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.User;
import com.spring.sample.model.mapper.UserMapper;

@Repository
public class UserDAOImpl implements UserDAO {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public boolean createNewUser(User user) {
    int affectedrows =
        jdbcTemplate.update(QUERY_ADD_NEW_USER, user.getUsername(), user.getPassword());
    return (affectedrows == 1);
  }

  public User findUserByUsername(String username) {

    List<User> users =
        jdbcTemplate.query(QUERY_SELECT_USER_BY_USERNAME, new UserMapper(), username);

    if (users.size() > 0) {
      return users.get(0);
    } else {
      return null;
    }


  }

}
