package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> query = currentSession.createQuery("from User order by lastName",
																User.class);
		List<User> users = query.getResultList();
		
		return users;
	}

	@Override
	public void saveUser(User user) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(user);
		
	}

	@Override
	public User getUser(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = currentSession.get(User.class, id);
		
		return user;
	}

}
