package com.hagi.interview.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hagi.interview.beans.Comment;
import com.hagi.interview.logic.CommentLogic;

@RestController
@RequestMapping(value = "/comment")
public class CommentApi {

	@Autowired
	private CommentLogic logic;

	// http://localhost:8080/CouponFixAttempt/rest/comment

	@GetMapping("/{commentId}")
	public Comment getCompany(@PathVariable long commentId) {
		return logic.getComment(commentId);
	}

	@PostMapping
	public long createComment(@RequestBody Comment comment) {
		return logic.createComment(comment);
	}

	@PutMapping
	public void updateComment(@RequestBody Comment comment) {
		logic.updateComment(comment);
	}

	@DeleteMapping("/{commentId}")
	public void removeComment(@PathVariable long commentId) {
		logic.removeComment(commentId);
	}

	@GetMapping
	public Collection<Comment> getAllComments() {
		return logic.getAllComments();
	}
}
