package com.mulcam.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {
	@PostMapping(value="")
	public ResponseEntity<String> addArticle(@RequestBody Article article) {
		ResponseEntity<String> result = null;
		try {
			System.out.println(article);
			result =  new ResponseEntity<String>("새글 등록 성공", HttpStatus.OK);
		} catch(Exception e) {
			result =  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	@RequestMapping(value="/{articleNo}", method =RequestMethod.GET)
	public ResponseEntity<Article> findArticle(@PathVariable("articleNo") Integer articleNo) {
		Article article = new Article();
		article.setArticleNo(articleNo);
		article.setWriter("김연아");
		article.setTitle("동계올림픽");
		article.setContent("피겨여왕의 일상");
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{articleNo}", method=RequestMethod.PUT)
	public ResponseEntity<String> modArticle(@PathVariable("articleNo") Integer articleNo, @RequestBody Article article){
		ResponseEntity<String> result = null;
		try {
			System.out.println(article);
			result =  new ResponseEntity<String>("새글 수정 성공", HttpStatus.OK);
		} catch(Exception e) {
			result =  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	@RequestMapping(value="/{articleNo}", method =RequestMethod.DELETE)
	public ResponseEntity<String> deleteArticle(@PathVariable("articleNo") Integer articleNo){
		ResponseEntity<String> result = null;
		try {
			result =  new ResponseEntity<String>(articleNo+ "글 삭제 성공", HttpStatus.OK);
		} catch(Exception e) {
			result =  new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return result;
	}
}
