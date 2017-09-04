package net.spring.backendproject.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Topic {
	
	@Id
	@Column(name="topic_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int topicId;
	
	@Column(name="topic_title")
	private String topicTitle;
	
	@Column(name="topic_desc")
	private String topicDesc;
	
	@Column(name="is_active")
	private boolean isActive;
	
	/*------------------------------*/
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "topic")
	private List<Article> listArticle;
	
	public List<Article> getListArticle() {
		return listArticle;
	}
	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}
	/*-------------------------------*/
	
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicTitle() {
		return topicTitle;
	}
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	public String getTopicDesc() {
		return topicDesc;
	}
	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	

}
