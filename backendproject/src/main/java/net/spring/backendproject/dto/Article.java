package net.spring.backendproject.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Article {
	
	@Id
	@Column(name = "article_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int articleId;
	
	@Column(name = "article_title")
	private String articleTitle;
	
	private String article;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date postDate;
	
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	/*---------------------------------*/
	@ManyToOne
	private Topic topic;
	
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleTitle="
				+ articleTitle + ", article=" + article + ", isActive="
				+ isActive + ", topic=" + topic + "]";
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	/*---------------------------------*/
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
