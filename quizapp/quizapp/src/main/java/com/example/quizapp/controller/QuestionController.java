package com.example.quizapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.entities.Question;

import com.example.quizapp.service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
		
		
	}
	@GetMapping("{id}")
	public Optional<Question> getQuestionById(@PathVariable("id")Integer id) {
		return questionService.getQuestionById(id);
		
	}
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable("category")String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@GetMapping("/difficultylevel/{difficultylevel}")
	public List<Question> getQuestionsBydifficultylevel(@PathVariable("difficultylevel")String difficultylevel){
		return questionService.getQuestionsBydifficultylevel(difficultylevel);
	}
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
}
