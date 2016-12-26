package com.spring.sample.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.sample.dao.UserRoleDAO;
import com.spring.sample.model.Role;
import com.spring.sample.model.User;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean createUserRole(User user, Role role) {
		int affectedRows = jdbcTemplate.update(QUERY_INSERT_USER_ROLE, user.getId(), role.getId());
		return (affectedRows == 1);
	}

}
