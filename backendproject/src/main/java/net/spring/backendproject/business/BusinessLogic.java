package net.spring.backendproject.business;

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
		//User user = userDAO.getUserById(1);
		List<Article> list = articleDAO.getScheduleArticle();
		
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
