package com.hagi.interview.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hagi.interview.beans.Article;
import com.hagi.interview.beans.Comment;

@Repository
public class ArticleDao {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	public ArticleDao() {
		super();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long createArticle(Article article) {
		entityManager.persist(article);
		return article.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void removeArticle(Long id) {
		Article article = entityManager.find(Article.class, id);
		entityManager.remove(article);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateArticle(Article article) {
		entityManager.merge(article);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Article readArticle(Long id) {
		Article article = entityManager.find(Article.class, id);
		return article;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Collection<Article> getAllArticles() {
		String hql = "from com.hagi.interview.beans.Article";
		Query query = entityManager.createQuery(hql);
		Collection<Article> allArticles = query.getResultList();
		return allArticles;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Collection<Comment> getAllArticleComments(long articleId) {
		Article article = entityManager.find(Article.class, articleId);
		Collection<Comment> comments = article.getComments();
		return comments;
	}

}
