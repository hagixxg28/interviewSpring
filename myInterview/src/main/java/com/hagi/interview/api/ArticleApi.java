package com.hagi.interview.api;

import java.sql.Date;
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

import com.hagi.interview.beans.Article;
import com.hagi.interview.beans.Comment;
import com.hagi.interview.logic.ArticleLogic;

@RestController
@RequestMapping(value = "/article")
public class ArticleApi {

	@Autowired
	private ArticleLogic logic;

	// http://localhost:8080/myInterview/rest/article

	@GetMapping("/{articleId}")
	public Article getArticle(@PathVariable long articleId) {
		return logic.getArticle(articleId);
	}

	@GetMapping("/comments/{articleId}")
	public Collection<Comment> getArticleComments(@PathVariable long articleId) {
		return logic.getAllArticleComments(articleId);
	}

	@GetMapping("/frame")
	public Article getArticleFrame() {
		Article article = new Article();
		article.setBody("Meou Roberto");
		article.setTitle("Hi");
		article.setId(1);
		article.setStartDate(new Date(System.currentTimeMillis()));

		return article;
	}

	@PostMapping
	public long createArticle(@RequestBody Article article) {
		return logic.createArticle(article);
	}

	@PutMapping
	public void updateArticle(@RequestBody Article article) {
		logic.updateArticle(article);
	}

	@DeleteMapping("/{articleId}")
	public void removeArticle(@PathVariable long articleId) {
		logic.removeArticle(articleId);
	}

	@GetMapping
	public Collection<Article> getAllArticles() {
		return logic.getAllArticles();
	}

//Just to check it's alive
	@GetMapping("/hi")
	public String greetings() {
		return "howdy";
	}
}
