package lk.exame.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.exame.test.service.AnswerService;

/**
 * 
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/answer")
public class AnswerController {

	@Autowired
	private AnswerService service;

	
	@GetMapping(value = "/getAnswers/{questionId}")
	public ResponseEntity<Object> getAnswerds(@PathVariable Integer questionId){

		try {
			return new ResponseEntity<Object>(service.getAnswers(questionId),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value = "/getAnswersByQestionId/{quesId}")
	public ResponseEntity<Object>getAnswersByQuesId(@PathVariable Integer quesId){
		try {
			return new ResponseEntity<Object>(service.getQuestions(quesId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/deleteAnswer/{answerId}")
	public ResponseEntity<Object>deleteAnswer(@PathVariable Integer answerId){
		try {
			return new ResponseEntity<Object>(service.delete(answerId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
