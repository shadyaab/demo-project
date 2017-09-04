package net.spring.backendproject.test;

import static org.junit.Assert.assertEquals;
import net.spring.backendproject.dao.EmailDAO;
import net.spring.backendproject.dao.TopicDAO;
import net.spring.backendproject.dao.UserDAO;
import net.spring.backendproject.dto.Email;
import net.spring.backendproject.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmailTestCase {

	private static AnnotationConfigApplicationContext context;
	private static EmailDAO emailDAO;
	private static TopicDAO topicDAO;
	private static UserDAO userDAO;
	private Email email;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.spring");
		context.refresh();
		emailDAO = (EmailDAO) context.getBean("emailDAO");
		topicDAO = (TopicDAO) context.getBean("topicDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void testAddEmail(){
//		
//		email = new Email();
//		email.setEmail("sh@gmail.com");
//		email.setTopic(topicDAO.get(1));
//		email.setUser(userDAO.getUserById(1));
//		email.setDefault(true);
//		
//		assertEquals("Failed to save email", true, emailDAO.addEmail(email));
//	}
	
//	@Test
//	public void testGetDefaultEmail(){
//		
//		User user = userDAO.getUserById(1);
//		
//		assertEquals("Failed to fetched default email", 1, emailDAO.getDefaultEmail(user).size());
//	}
	
//	@Test
//	public void testRetrieveRegisteredEmail(){
//		
//		assertEquals("Failed to fetched default email", "success" , emailDAO.retrieveRegisteredEmail());
//	}
	
	
//	@Test
//	public void testGetRegisteredEmail(){
//		
//		assertEquals("Failed to fetched default email", 3 , emailDAO.getRegisteredEmail());
//	}
	
}














