package com.example.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quizapp.dao.QuestionDao;
import com.example.quizapp.entities.Question;

@Service
public class QuestionService {
	@Autowired
	private QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public Optional<Question> getQuestionById(Integer id) {
		// TODO Auto-generated method stub
		return questionDao.findById(id);
	}
	public List<Question> getQuestionsByCategory(String category){
		return questionDao.findByCategory(category);
	}
	public List<Question> getQuestionsBydifficultylevel(String difficultylevel){
		return questionDao.findBydifficultylevel(difficultylevel);
	}
	public ResponseEntity<String> addQuestion(Question question) {
		try {
			
		questionDao.save(question);
		
		return new ResponseEntity<>( "SUCCESS",HttpStatus.CREATED);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return new ResponseEntity<>("Question already exist",HttpStatus.METHOD_NOT_ALLOWED);
	
}
}