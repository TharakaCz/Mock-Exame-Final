package lk.exame.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import lk.exame.test.dto.SubmitQuestionDTO;
import lk.exame.test.service.ExamService;

/**
 * 
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/exam")
public class ExamController {

	@Autowired
	private ExamService service;

	  
	  @DeleteMapping(value="/deleteExam/{examId}")
	  private ResponseEntity<Object>delete(@PathVariable Integer examId){
		  
		  try {
			return new ResponseEntity<Object>(service.delete(examId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	  
	  @PostMapping(value = "/saveAnswer/{userName}/{languageId}")
	  private ResponseEntity<Object>saveQuestionAndAnswers(@RequestBody List<SubmitQuestionDTO>submitQuestionDTOs,@PathVariable String userName , @PathVariable Integer languageId){
		  
		 
		  try {
			return new ResponseEntity<Object>(service.submitQuestion(submitQuestionDTOs,userName,languageId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	  
	 

	  @GetMapping(value = "/getUserExams/{userName}")
	  private ResponseEntity<Object>getUserExames(@PathVariable String userName){
		  
		  try {
			return new ResponseEntity<Object>(service.getExamId(userName),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	  
	  @GetMapping(value="/getExamResult/{examId}")
	  private ResponseEntity<Object>getResult(@PathVariable Integer examId){
		  
		  try {
			return new ResponseEntity<Object>(service.getExamResult(examId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	  
	  @GetMapping(value="/getResult/{userName}")
	  private ResponseEntity<Object>findResultExame(@PathVariable String userName){
		  try {
			return new ResponseEntity<Object>(service.getResultByExamUserName(userName),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	  }
	
	  
	  
}
