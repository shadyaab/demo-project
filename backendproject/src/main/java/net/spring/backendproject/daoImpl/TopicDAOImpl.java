package net.spring.backendproject.daoImpl;

import java.util.List;

import net.spring.backendproject.dao.TopicDAO;
import net.spring.backendproject.dto.Article;
import net.spring.backendproject.dto.Topic;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("topicDAO")
@Transactional
public class TopicDAOImpl implements TopicDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean add(Topic topic){
		try{
			sessionFactory
				.getCurrentSession()
					.persist(topic);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public Topic get(int topicId) {
		try{
			System.out.println("inside get function");
			return sessionFactory
				.getCurrentSession()
					.get(Topic.class, topicId);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}

	public List<Topic> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Topic", Topic.class)
						.getResultList();
	}

	public boolean update(Topic topic) {
		try{
			sessionFactory
				.getCurrentSession()
					.update(topic);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Topic topic) {
		try{
			topic.setActive(false);
			sessionFactory
				.getCurrentSession()
					.update(topic);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public List<Topic> listActiveTopic() {
		String selectActiveTopic = "FROM Topic WHERE isActive = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveTopic, Topic.class)
						.setParameter("active", true)
							.getResultList();
	}
	
//	public List<Article> listArticle(){
//		String selectQuery = "From Topui"
//	}
	

}
