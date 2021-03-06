package lk.exame.test.controller;

import java.util.List;

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

/**
 * 
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/ques")
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	
	@PostMapping(value="/saveQuestionAnswer")
	public ResponseEntity<Object>saveQuestionAnswer(@RequestBody QuestionsDTO questionsDTO){
		System.out.println("Question Call =/"+questionsDTO.getSubjectId());
		try {
			return new ResponseEntity<Object>(service.saveQuestionAnswer(questionsDTO),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value ="/getAllQuestions")
	public ResponseEntity<Object>getAllQuestions(){
		System.out.println("Call");
		try {
			return new ResponseEntity<Object>(service.getAllQuestions(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/updateQuesAnswer")
	public ResponseEntity<Object>update(@RequestBody QuestionsDTO questionsDTO){
		try {
			return  new ResponseEntity<Object>(service.update(questionsDTO),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/deleteAnswer/{quesId}")
	public ResponseEntity<Object>delete(@PathVariable Integer quesId){
		
		try {
			return new ResponseEntity<Object>(service.delete(quesId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/getQuestion/{languageId}/{subjectId}")
	private ResponseEntity<Object>getQuestions(@RequestBody List<Integer>questionIds, @PathVariable("languageId") Integer languageId,@PathVariable("subjectId")Integer subjectId){
		try {
			System.out.println("get_question_controller_language =/"+languageId);
			System.out.println("get_question_controller_subject =/"+subjectId);
			return new ResponseEntity<Object>(service.getQuestion(questionIds,languageId,subjectId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/editQuestions/{quesId}")
	public ResponseEntity<Object>editQuestions(@PathVariable Integer quesId){
		try {
			return new ResponseEntity<Object>(service.edit(quesId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllQuestionInLanguage/{languageId}")
	public ResponseEntity<Object>getAllQuestionInLanguage(@PathVariable("languageId") Integer languageId){
		
		try {
			return new ResponseEntity<Object>(service.getAllQuestionInLanguage(languageId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllQuestionInSubject/{subjectId}")
	public ResponseEntity<Object>getAllQuestionInSubject(@PathVariable("subjectId")Integer subjectId){
		try {
			return new ResponseEntity<Object>(service.getAllQuestionInSubject(subjectId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllQuestionInLanguageAndSubject/{subjectId}/{languageId}")
	public ResponseEntity<Object>getAllQuestionInSubjectAndLanguage(@PathVariable("subjectId")Integer subjectId,@PathVariable("languageId")Integer languageId){
		try {
			return new ResponseEntity<Object>(service.getAllQuestionInLanguageAndSubject(languageId, subjectId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
