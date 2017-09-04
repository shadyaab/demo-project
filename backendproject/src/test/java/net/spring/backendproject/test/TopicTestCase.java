package net.spring.backendproject.test;

import static org.junit.Assert.assertEquals;
import net.spring.backendproject.dao.TopicDAO;
import net.spring.backendproject.dto.Topic;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TopicTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static TopicDAO topicDAO;
	private Topic topic;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.spring.backendproject");
		context.refresh();
		topicDAO = context.getBean("topicDAO",TopicDAO.class);
		
	}
	
	@Test
	public void testAdd(){
		topic = new Topic();
		topic.setTopicTitle("2nd Title");
		topic.setTopicDesc("This is topic description");
		topic.setActive(true);
		
		// Adding Topic
		assertEquals("Somethining went wrong in adding topic", true, topicDAO.add(topic));
	}

}
