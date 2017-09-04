package net.spring.backendproject.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import net.spring.backendproject.dao.ArticleDAO;
import net.spring.backendproject.dao.TopicDAO;
import net.spring.backendproject.dto.Article;
import net.spring.backendproject.dto.Topic;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArticelTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ArticleDAO articleDAO;
	private static TopicDAO topicDAO;
	private Topic topic;
	private Article article;
	
	@BeforeClass
	public static void  init(){
		context = new  AnnotationConfigApplicationContext();
		context.scan("net.spring");
		context.refresh();
		articleDAO = (ArticleDAO) context.getBean("articleDAO");
		topicDAO = (TopicDAO) context.getBean("topicDAO");
	}
	
//	@Test
//	public void testAdd(){
//		topic = new Topic();
//		topic.setActive(true);
//		topic.setTopicDesc("This is Sport topic Description");
//		topic.setTopicTitle("Sports");
//		
//		assertEquals("Failed to add Topic", true, topicDAO.add(topic));
//		article = new Article();
//		article.setActive(true);
//		article.setArticle("This is 1st article");
//		article.setArticleTitle("This is the title of first article");
//		article.setTopic(topic);
//		
//		assertEquals("Failed to add Article", true, articleDAO.add(article));
//		article = new Article();
//		article.setActive(true);
//		article.setArticle("This is 2nd article");
//		article.setArticleTitle("This is the title of second article");
//		article.setTopic(topic);
//		
//		assertEquals("Failed to add Article", true, articleDAO.add(article));
//		
//	}
	
//	@Test
//	public void testAdd(){
//		List<Article> listArticle = new ArrayList<Article>();
//		
//		topic = new Topic();
//		topic.setActive(true);
//		topic.setTopicDesc("This is Sport topic Description");
//		topic.setTopicTitle("Sports");
//		
//		article = new Article();
//		article.setActive(true);
//		article.setArticle("This is 1st article");
//		article.setArticleTitle("This is the title of first article");
//		article.setTopic(topic);
//		listArticle.add(article);
//		
//		article = new Article();
//		article.setActive(true);
//		article.setArticle("This is 2nd article");
//		article.setArticleTitle("This is the title of second article");
//		article.setTopic(topic);
//		listArticle.add(article);
//		topic.setListArticle(listArticle);
//		
//		assertEquals("Failed to add Article", true, topicDAO.add(topic));
//		
//	}
	
	@Test
	public void getScheduleArticle(){
		
		assertEquals("Failed to add Article", 3, articleDAO.getScheduleArticle().size());
		
	}
	
}







