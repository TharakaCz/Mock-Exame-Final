package lk.exame.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lk.exame.test.dto.QuestionsDTO;
import lk.exame.test.service.QuestionService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/ques")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	
	@PostMapping(value="/saveQuestionAnswer")
	public ResponseEntity<Object>saveQuestionAnswer(@RequestBody QuestionsDTO questionsDTO)throws Exception{
		System.out.println("Question Call =/"+questionsDTO.getSubjectId());
		return new ResponseEntity<Object>(service.saveQuestionAnswer(questionsDTO),HttpStatus.OK);
	}
	
	@GetMapping(value ="/getAllQuestions")
	public ResponseEntity<Object>getAllQuestions()throws Exception{
		System.out.println("Call");
		return new ResponseEntity<Object>(service.getAllQuestions(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/updateQuesAnswer")
	public ResponseEntity<Object>update(@RequestBody QuestionsDTO questionsDTO)throws Exception{
		return  new ResponseEntity<Object>(service.update(questionsDTO),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteAnswer/{quesId}")
	public ResponseEntity<Object>delete(@PathVariable Integer quesId)throws Exception{
		
		return new ResponseEntity<Object>(service.delete(quesId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/editQuestions/{quesId}")
	public ResponseEntity<Object>editQuestions(@PathVariable Integer quesId)throws Exception{
		return new ResponseEntity<Object>(service.edit(quesId),HttpStatus.OK);
	}
}
