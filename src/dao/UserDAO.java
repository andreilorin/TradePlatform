package dao;

import java.util.List;
import entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User user);

	public User getUser(int id);
}
