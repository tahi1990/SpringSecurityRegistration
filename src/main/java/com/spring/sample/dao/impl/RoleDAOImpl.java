package com.spring.sample.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.sample.dao.RoleDAO;
import com.spring.sample.model.Role;
import com.spring.sample.model.User;
import com.spring.sample.model.mapper.RoleMapper;

@Repository
public class RoleDAOImpl implements RoleDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Set<Role> getRolesOfUser(User user) {
    List<Role> roleList =
        jdbcTemplate.query(QUERY_GET_ROLES_OF_USER, new RoleMapper(), user.getId());

    Set<Role> roles = new HashSet<Role>(roleList);
    return roles;
  }

  public boolean createNewRole(Role role) {
    int affectedRows = jdbcTemplate.update(QUERY_CREATE_NEW_ROLE, role.getName());
    return (affectedRows == 1);
  }

  public List<Role> getAllRoles() {
    List<Role> roleList = jdbcTemplate.query(QUERY_GET_ALL_ROLES, new RoleMapper());

    return roleList;
  }

}
