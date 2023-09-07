package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.entities.Question;
import com.example.quizapp.entities.QuestionWrapper;
import com.example.quizapp.entities.Response;
import com.example.quizapp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	
	@Autowired
	QuizService quizService;
	
	//http://localhost:8080/quiz/create?category=java&numQ=5&title=jquiz
	//numq--no of questions
	@PostMapping("/create")
	public ResponseEntity<String>createQuiz(@RequestParam String category,@RequestParam int numQ ,@RequestParam String title){
       return quizService.createQuiz(category,numQ,title);
}
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>>getQuestions(@PathVariable Integer id){
		return quizService.getQuestions(id);
		
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
    }
}
