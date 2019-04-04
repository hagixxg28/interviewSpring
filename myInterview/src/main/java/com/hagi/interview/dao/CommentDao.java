package com.hagi.interview.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hagi.interview.beans.Comment;

@Repository
public class CommentDao {
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	public CommentDao() {
		super();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public long createComment(Comment comment) {
		entityManager.persist(comment);
		return comment.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void removeComment(Long id) {
		Comment Comment = entityManager.find(Comment.class, id);
		entityManager.remove(Comment);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateComment(Comment Comment) {
		entityManager.merge(Comment);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Comment readComment(Long id) {
		Comment Comment = entityManager.find(Comment.class, id);
		return Comment;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Collection<Comment> getAllComments() {
		String hql = "from com.hagi.interview.beans.Comment";
		Query query = entityManager.createQuery(hql);
		Collection<Comment> allComments = query.getResultList();
		return allComments;
	}

}
