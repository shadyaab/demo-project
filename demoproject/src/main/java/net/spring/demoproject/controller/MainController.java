package net.spring.demoproject.controller;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.spring.backendproject.business.BusinessLogic;
import net.spring.backendproject.dao.ArticleDAO;
import net.spring.backendproject.dao.EmailDAO;
import net.spring.backendproject.dao.TopicDAO;
import net.spring.backendproject.dao.UserDAO;
import net.spring.backendproject.dto.Article;
import net.spring.backendproject.dto.Email;
import net.spring.backendproject.dto.TestClass;
import net.spring.backendproject.dto.Topic;
import net.spring.backendproject.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private TopicDAO topicDAO;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private EmailDAO emailDAO;
	
	@Autowired
	private BusinessLogic logic;

	@RequestMapping("/home")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("layout");
		mv.addObject("title", "Home Page");
		mv.addObject("userClickHome", true);
		mv.addObject("topics",topicDAO.listActiveTopic());
		
		return mv;
	}
	
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public ModelAndView setting(){
		ModelAndView mv = new ModelAndView("layout");
		mv.addObject("title", "Management Page");
		mv.addObject("userClickManagement", true);
		mv.addObject("topics",topicDAO.listActiveTopic());
		
		Article article = new Article();
		article.setActive(true);
		
		Topic topic = new Topic();
		topic.setActive(true);
		
		mv.addObject("article", article);
		mv.addObject("topic", topic);
		
		return mv;
	}
	@RequestMapping(value="/management", method = RequestMethod.POST)
	public String addTopic(@ModelAttribute("article") Article article, BindingResult results, Model model){
		model.addAttribute("title", "Management Page");
		model.addAttribute("userClickManagement", true);
		
		article.setActive(true);
		Date date = new Date();
		article.setPostDate(new Timestamp(date.getTime()));
		articleDAO.add(article);
		return "redirect:/management";
	}
	
	@RequestMapping(value = "/add/topic", method = RequestMethod.POST)
	public String addTopic(@ModelAttribute("topic") Topic topic, BindingResult results, Model model){
		model.addAttribute("title", "Management Page");
		model.addAttribute("userClickManagement", true);
		
		topic.setActive(true);
		topicDAO.add(topic);
		
		return "redirect:/management";
	}
	
	
	@RequestMapping(value="/notification", method= RequestMethod.GET)
	public ModelAndView notification(){
		ModelAndView mv = new ModelAndView("layout");
		mv.addObject("title", "Notification Page");
		mv.addObject("userClickNotification", true);
		
		mv.addObject("topics", topicDAO.listActiveTopic());
		//User user = userDAO.getUserById(1);
		
		String defaultEmail = "";
		for(String email : emailDAO.getDefaultEmail()){
			defaultEmail += email + ";";
		}
		mv.addObject("defaultEmail", defaultEmail);
	
		logic.sendEmail();
		return mv;
	}
	
	@RequestMapping(value = "/defaultEmailRegister", method = RequestMethod.POST)
	@ResponseBody
	public String defaultEmailRegister(@RequestBody List<String> list){
		List<Email> listEmail = new ArrayList<Email>();
		User user = userDAO.getUserById(1);
		
		for(String str: list){
			Email email= new Email();
			email.setDefault(true);
			email.setEmail(str);
			email.setUser(user);
			listEmail.add(email);
		}
		emailDAO.saveDefaultEmail(listEmail);
		
		return "success";
	}
	
	@RequestMapping(value = "/notification", method = RequestMethod.POST)
	@ResponseBody
	public String saveNotification(@RequestBody List<Email> emails){
		List<Email> list = new ArrayList<Email>();
		User user = userDAO.getUserById(1);
		
	    Iterator<Email> itr = emails.iterator();
	    while(itr.hasNext()){
	    	Email email = itr.next();
	    	email.setUser(user);
	    	list.add(email);
	    }
	    emailDAO.saveAllEmail(list);
	    
		return "success";
	}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	@ResponseBody
	public List<TestClass> test( ){
		System.out.println("success");
		List<TestClass> list = new ArrayList<TestClass>();
		
		TestClass testClass = new TestClass();
		testClass.setId(1);
		testClass.setName("sady");
		
		list.add(testClass);
		
		TestClass testClass1 = new TestClass();
		testClass1.setId(2);
		testClass1.setName("shadyaab");
		
		list.add(testClass1);
		
		return list;
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	@ResponseBody
	public int test1(@RequestBody List<TestClass> list){
		
		System.out.println(list.size());
		return list.size();
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)
	@ResponseBody
	public String test2(@RequestBody String name){
		
		System.out.println(name);
		return name;
	}
	
}







