package net.spring.backendproject.daoImpl;

import net.spring.backendproject.dao.UserDAO;
import net.spring.backendproject.dto.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUser(User user) {
		try{
			sessionFactory
				.getCurrentSession()
					.persist(user);
			return true;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public User getUserById(int userId) {
		try{
			return sessionFactory
					.getCurrentSession()
						.get(User.class, userId);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	

}
