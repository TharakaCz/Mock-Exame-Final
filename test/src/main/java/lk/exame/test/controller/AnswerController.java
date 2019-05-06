package lk.exame.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.exame.test.dto.AnswersDTO;
import lk.exame.test.service.AnswerService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/answer")
public class AnswerController {

	@Autowired
	private AnswerService service;

	@PostMapping(value = "/save")
	public ResponseEntity<Object>save(@RequestBody AnswersDTO answersDTO)throws Exception{
		return new ResponseEntity<Object>(service.save(answersDTO),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getAnswers/{questionId}")
	public ResponseEntity<Object>getAnswerds(@PathVariable Integer questionId)throws Exception{
		return new ResponseEntity<Object>(service.getAnswers(questionId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAnswersByQestionId/{quesId}")
	public ResponseEntity<Object>getAnswersByQuesId(@PathVariable Integer quesId)throws Exception{
		return new ResponseEntity<Object>(service.getQuestions(quesId),HttpStatus.OK);
	}
}
