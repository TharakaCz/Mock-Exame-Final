package lk.exame.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.exame.test.service.ResultService;

/**
 * 
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/result")
public class ResultController {

	@Autowired
	private ResultService resultService;
	
	@GetMapping(value = "/findResult/{examId}")
	private ResponseEntity<Object>findResultExamId(@PathVariable Integer examId){
		
		try {
			return new ResponseEntity<Object>(resultService.findByExamId(examId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@GetMapping(value = "/findResultUserName/{userName}")
	private ResponseEntity<Object>findResultQuesName(@PathVariable String userName){
		try {
			return new ResponseEntity<Object>(resultService.findByUserName(userName),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
	}
}
