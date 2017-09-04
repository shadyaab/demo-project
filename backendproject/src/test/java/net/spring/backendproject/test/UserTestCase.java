package net.spring.backendproject.test;

import static org.junit.Assert.assertEquals;
import net.spring.backendproject.dao.UserDAO;
import net.spring.backendproject.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("net.spring");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAddUser(){
		user = new User();
		user.setActive(true);
		user.setFirstName("Shadyaab");
		user.setLastName("Akhtar");
		user.setRole("USER");
		
		assertEquals("Failed to save user", true, userDAO.addUser(user));
	}
	
}
