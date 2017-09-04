package net.spring.backendproject.daoImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.spring.backendproject.dao.ArticleDAO;
import net.spring.backendproject.dto.Article;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("articleDAO")
@Transactional
public class ArticleDAOImpl implements ArticleDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Article get(int articleId) {
		try{
			return sessionFactory
					.getCurrentSession()
						.get(Article.class, articleId);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	public List<Article> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Article", Article.class)
						.getResultList();
	}

	public boolean add(Article article) {
		try{
			sessionFactory
				.getCurrentSession()
					.persist(article);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(Article article) {

		try{
			sessionFactory
				.getCurrentSession()
					.update(article);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Article article) {
		article.setActive(false);
		try{
			sessionFactory
				.getCurrentSession()
					.update(article);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

	public List<Article> listActiveArticle() {
		String selectActiveTopic = "FROM Article where isActive = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveTopic, Article.class)
						.setParameter("active", true)
							.getResultList();
	}

	public List<Article> getLatestActiveArticle(int count) {
		String query = "FROM Article WHERE isActive = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(query, Article.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

	public List<Article> getScheduleArticle() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Article.class);
		criteria.add(Restrictions.lt("postDate",new Timestamp((new Date()).getTime())));
		return criteria.list();
	}

}
