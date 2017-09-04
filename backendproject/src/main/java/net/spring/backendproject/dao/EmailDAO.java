package net.spring.backendproject.dao;

import java.util.List;

import net.spring.backendproject.dto.Email;
import net.spring.backendproject.dto.Topic;
import net.spring.backendproject.dto.User;

public interface EmailDAO {

	boolean addEmail(Email email); 
	boolean saveAllEmail(List<Email> list);
	List<String> getDefaultEmail();
	boolean saveDefaultEmail(List<Email> listEmail);
//	boolean deleteRegisteredEmail();
//	boolean deleteDefaultEmail();
	
	//String retrieveRegisteredEmail();
	List<String> getRegisteredEmail(Topic topic);
}
