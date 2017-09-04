package net.spring.backendproject.dao;

import java.util.List;

import net.spring.backendproject.dto.Topic;

public interface TopicDAO {
	
	Topic get(int topicId);
	List<Topic> list();
	boolean add(Topic topic);
	boolean update(Topic topic);
	boolean delete(Topic topic);
	
	/*
	 * Business Methods
	 * */
	List<Topic> listActiveTopic();

}
