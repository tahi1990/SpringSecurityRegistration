package com.spring.sample.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.sample.dao.RoleDAO;
import com.spring.sample.dao.UserDAO;
import com.spring.sample.model.Role;
import com.spring.sample.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserDAO userDao;

  @Autowired
  private RoleDAO roleDao;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDao.findUserByUsername(username);

    Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

    Set<Role> roles = roleDao.getRolesOfUser(user);
    for (Role role : roles) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), grantedAuthorities);
  }

}
