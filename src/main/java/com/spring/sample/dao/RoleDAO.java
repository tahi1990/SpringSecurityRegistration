package com.spring.sample.dao;

import java.util.List;
import java.util.Set;

import com.spring.sample.model.Role;
import com.spring.sample.model.User;

public interface RoleDAO {
  public static final String QUERY_GET_ROLES_OF_USER =
      "SELECT r.id, r.name, user.user_id FROM user_role user INNER JOIN role r ON user.role_id = r.id WHERE user.user_id = ?";

  public static final String QUERY_GET_ALL_ROLES = "SELECT * FROM role";

  public Set<Role> getRolesOfUser(User user);

  public List<Role> getAllRoles();
}
