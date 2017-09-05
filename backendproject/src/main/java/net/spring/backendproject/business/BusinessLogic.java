package net.spring.backendproject.business;

import java.util.Calendar;
import java.util.List;

import net.spring.backendproject.dao.ArticleDAO;
import net.spring.backendproject.dao.EmailDAO;
import net.spring.backendproject.dao.UserDAO;
import net.spring.backendproject.dto.Article;
import net.spring.backendproject.dto.User;

import org.springframework.beans.factory.annotation.Autowired;


public class BusinessLogic {
	
	@Autowired
	private EmailDAO emailDAO;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	public String hello(){
		System.out.println("hello");
		return "success";
	}
	
	public void sendEmail(){
		//Set Time for scheduling email delivery
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 22);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		List<Article> list = articleDAO.getScheduleArticle(calendar);
		
		for(Article article: list){
			List<String> emails = emailDAO.getRegisteredEmail(article.getTopic());
			emails.addAll(emailDAO.getDefaultEmail());
			
			System.out.println("--------------------------------------------------------");
			System.out.println("Title : " + article.getArticleTitle() + "     Topic : " + article.getTopic().getTopicTitle());
			System.out.println("Article : " + article.getArticle() + "\n");
			System.out.println("Send To: " + emails);
			System.out.println("--------------------------------------------------------");
			System.out.println("\n\n"); 
			
		}
	}

}
