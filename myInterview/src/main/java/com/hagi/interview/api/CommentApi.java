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
		return logic.getcomment(commentId);
	}

	@PostMapping
	public void createCompany(@RequestBody Comment comment) {
		logic.createcomment(comment);
	}

	@PutMapping
	public void updateCompany(@RequestBody Comment comment) {
		logic.updatecomment(comment);
	}

	@DeleteMapping("/{commentId}")
	public void removeCompany(@PathVariable long commentId) {
		logic.removecomment(commentId);
	}

	@GetMapping
	public Collection<Comment> getAllCompanies() {
		return logic.getAllcomments();
	}
}
