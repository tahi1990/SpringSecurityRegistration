package com.spring.sample.service;

import org.springframework.stereotype.Service;

import com.spring.sample.model.User;

@Service
public interface UserService {
  void save(User user);

  User findByUsername(String username);
}
