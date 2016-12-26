package com.spring.sample.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.sample.dao.RoleDAO;
import com.spring.sample.dao.UserDAO;
import com.spring.sample.dao.UserRoleDAO;
import com.spring.sample.model.Role;
import com.spring.sample.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private RoleDAO roleDao;
	@Autowired
	private UserRoleDAO userroleDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		Set<Role> roles = new HashSet<Role>(roleDao.getAllRoles());
		user.setRoles(roles);
		userDao.createNewUser(user);

		User createdUser = userDao.findUserByUsername(user.getUsername());

		for (Role role : roles) {
			userroleDao.createUserRole(createdUser, role);
		}
	}

	public User findByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

}
