package net.spring.backendproject.dao;

import java.util.List;

import net.spring.backendproject.dto.Article;

public interface ArticleDAO {

	Article get(int articleId);
	List<Article> list();
	boolean add(Article article);
	boolean update(Article article);
	boolean delete(Article article);
	
	/*
	 * Business Methods
	 * */
	List<Article> listActiveArticle(); 
	List<Article> getLatestActiveArticle(int count);
	List<Article> getScheduleArticle();
}
