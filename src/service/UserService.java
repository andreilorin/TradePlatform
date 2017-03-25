package service;

import java.util.List;

import entity.User;

public interface UserService {
	
	List<User> getUsers();

	void saveUser(User user);

	User getUser(int id);

}
