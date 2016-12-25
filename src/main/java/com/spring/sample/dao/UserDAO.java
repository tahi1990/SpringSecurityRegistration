package com.spring.sample.dao;

import com.spring.sample.model.User;

public interface UserDAO {
  public static final String QUERY_ADD_NEW_USER =
      "INSERT INTO user(username,password) VALUES (?,?)";

  public static final String QUERY_SELECT_USER_BY_USERNAME =
      "SELECT * FROM user WHERE username = ?";

  public boolean createNewUser(User user);

  public User findUserByUsername(String username);
}
