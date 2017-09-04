package net.spring.backendproject.dao;

import net.spring.backendproject.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getUserById(int userId);
	
}
