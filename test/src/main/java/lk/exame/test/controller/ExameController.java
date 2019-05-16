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
import lk.exame.test.service.ExameService;

/**
 * 
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/exame")
public class ExameController {

	@Autowired
	private ExameService service;
	
	@GetMapping(value = "/currentTime")
	private ResponseEntity<Object> currentTime()throws Exception{
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		
		return new ResponseEntity<Object>(formatter.format(date),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/currantDate")
	private ResponseEntity<Object>currentDate()throws Exception{
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
	
		return new ResponseEntity<Object>(formatter.format(date),HttpStatus.OK);
	}
	
	@GetMapping(value="/currentDateTime")
	private ResponseEntity<Object>currentDateTime()throws Exception{
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
	
		return new ResponseEntity<Object>(formatter.format(date),HttpStatus.OK);
		
	}

	/*
	 * @GetMapping(value="/getQuesAns/{langName}") private
	 * ResponseEntity<Object>getAllQuesAns(@PathVariable String langName)throws
	 * Exception{ System.out.println("Question Answer meth "); return new
	 * ResponseEntity<Object>(service.getQuestionAnsers(langName),HttpStatus.OK); }
	 */
	

	  @PostMapping(value="/getQuestion/{languageId}")
	  private ResponseEntity<Object>getQuestion(@RequestBody List<Integer> questionIds,@PathVariable Integer languageId)throws Exception{
		  return new ResponseEntity<Object>(service.getQuestion(questionIds,languageId),HttpStatus.OK);
	  }
	/*
	 * @PostMapping(value = "/saveExame") private
	 * ResponseEntity<Object>save(@RequestBody ExameDTO exameDTO)throws Exception{
	 * 
	 * return new ResponseEntity<Object>(service.save(exameDTO),HttpStatus.OK);
	 * 
	 * }
	 */
	  
	  @DeleteMapping(value="/deleteExame/{exameId}")
	  private ResponseEntity<Object>delete(@PathVariable Integer exameId)throws Exception{
		  
		  return new ResponseEntity<Object>(service.delete(exameId),HttpStatus.OK);
	  }
	  
	  @PostMapping(value = "/saveAnswer/{userName}/{languageId}")
	  private ResponseEntity<Object>saveQuestionAndAnswers(@RequestBody List<SubmitQuestionDTO>submitQuestionDTOs,@PathVariable String userName , @PathVariable Integer languageId)throws Exception{
		  
		  return new ResponseEntity<Object>(service.submitQuestion(submitQuestionDTOs,userName,languageId),HttpStatus.OK);
	  }
	  
	
	/*
	 * @GetMapping(value = "/getBackQuestions/{quesId}") private
	 * ResponseEntity<Object>getBackStep(@PathVariable Integer quesId)throws
	 * Exception{
	 * 
	 * return new ResponseEntity<Object>(service.backStep(quesId),HttpStatus.OK);
	 * 
	 * }
	 */
	 

	  @GetMapping(value = "/getUserExames/{userName}")
	  private ResponseEntity<Object>getUserExames(@PathVariable String userName)throws Exception{
		  
		  return new ResponseEntity<Object>(service.getExameId(userName),HttpStatus.OK);
	  }
	  
	  @GetMapping(value="/getExameResult/{exameId}")
	  private ResponseEntity<Object>getResult(@PathVariable Integer exameId)throws Exception{
		  
		  return new ResponseEntity<Object>(service.getExameResult(exameId),HttpStatus.OK);
	  }
	  
	  @GetMapping(value="/getResult/{userName}")
	  private ResponseEntity<Object>findResultExame(@PathVariable String userName)throws Exception{
		  return new ResponseEntity<Object>(service.getResultByExameUserName(userName),HttpStatus.OK);
	  }
	
	  
	  
}
