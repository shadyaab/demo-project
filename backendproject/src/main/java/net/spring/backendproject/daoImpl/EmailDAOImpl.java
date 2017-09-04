package net.spring.backendproject.daoImpl;

import java.util.List;

import net.spring.backendproject.dao.EmailDAO;
import net.spring.backendproject.dto.Email;
import net.spring.backendproject.dto.Topic;
import net.spring.backendproject.dto.User;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("emailDAO")
@Transactional
public class EmailDAOImpl implements EmailDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addEmail(Email email) {
		
		try{
			sessionFactory
				.getCurrentSession()
					.persist(email);
			return true;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	public boolean saveAllEmail(List<Email> list) {
		
		Session session = sessionFactory.getCurrentSession();
		int i=0;
		for(Email item : list){
			System.out.println(item.getEmail());
			if(item.getEmail() != null && item.getEmail().length() > 0){
				session.save(item);
			}
			if(i % 5 == 0){
				session.flush();
				session.clear();
			}
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public List<String> getDefaultEmail() {
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Email.class);
		List result = criteria.add(Restrictions.eq("isDefault", true))
							.setProjection(Projections.property("email"))
							.list();
		
		return result;
	}

	public boolean saveDefaultEmail(List<Email> listEmail) {
		
		Session session = sessionFactory.getCurrentSession();
		for(Email email: listEmail){
			session.save(email);
		}
		return true;
	}

	public List<String> getRegisteredEmail(Topic topic) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Email.class);
		criteria.setProjection(Projections.property("email"));
		criteria.add(Restrictions.eq("topic", topic));
		return criteria.list();
	}

//	public String retrieveRegisteredEmail() {
//		Session session= sessionFactory.getCurrentSession();
//		
//		@SuppressWarnings("deprecation")
//		Criteria criteria = session.createCriteria(Article.class,"a");
//		criteria.add(Restrictions.lt("postDate", new Timestamp((new Date()).getTime())));
//		criteria.setProjection(Projections.projectionList()
//				.add(Projections.property("a.articleTitle")));
//		List<String> list = criteria.list();
//		System.out.println(list);
//		return "success";
//	}

	
	
	
	
	
	
	
	
	
	
	
//	public boolean deleteRegisteredEmail() {
//		String query = "DELETE FROM email WHERE isDefault = :isDefault";
//		try{
//			sessionFactory
//				.getCurrentSession()
//					.createQuery(query)
//						.setParameter("isDefault", true)
//							.executeUpdate();
//			return true;
//		}
//		catch(Exception ex){
//			ex.printStackTrace();
//		}
//		
//		return false;
//	}
//
//	public boolean deleteDefaultEmail() {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	

}
