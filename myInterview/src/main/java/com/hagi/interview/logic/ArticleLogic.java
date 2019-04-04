package com.hagi.interview.logic;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hagi.interview.beans.Article;
import com.hagi.interview.beans.Comment;
import com.hagi.interview.dao.ArticleDao;

@Controller
public class ArticleLogic {

	// This logic wouldn't contain any validation- it's just a necessary layer in
	// the Spring Framework

	@Autowired
	private ArticleDao dao;

	public ArticleLogic() {
		super();
	}

	public Article getArticle(long articleId) {
		return dao.readArticle(articleId);
	}

	public long createArticle(Article article) {
		return dao.createArticle(article);
	}

	public void updateArticle(Article article) {
		dao.updateArticle(article);
	}

	public void removeArticle(long articleId) {
		dao.removeArticle(articleId);
	}

	public Collection<Article> getAllArticles() {
		Collection<Article> list = new ArrayList<>();
		list = dao.getAllArticles();
		return list;
	}

	public Collection<Comment> getAllArticleComments(long articleId) {
		Collection<Comment> list = new ArrayList<>();
		list = dao.getAllArticleComments(articleId);
		return list;
	}

}
