package com.spring.sample.dao;

import com.spring.sample.model.Role;
import com.spring.sample.model.User;

public interface UserRoleDAO {
	public static final String QUERY_INSERT_USER_ROLE = "INSERT INTO user_role(user_id, role_id) VALUES (?, ?)";

	public boolean createUserRole(User user, Role role);
}
