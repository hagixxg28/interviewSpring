package com.hagi.interview.logic;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hagi.interview.beans.Comment;
import com.hagi.interview.dao.CommentDao;

@Controller
public class CommentLogic {

	@Autowired
	private CommentDao dao;

	public CommentLogic() {
		super();
	}

	public Comment getComment(long commentId) {
		return dao.readComment(commentId);
	}

	public long createComment(Comment comment) {
		return dao.createComment(comment);
	}

	public void updateComment(Comment comment) {
		dao.updateComment(comment);
	}

	public void removeComment(long commentId) {
		dao.removeComment(commentId);
	}

	public Collection<Comment> getAllComments() {
		Collection<Comment> list = new ArrayList<>();
		list = dao.getAllComments();
		return list;
	}

}
