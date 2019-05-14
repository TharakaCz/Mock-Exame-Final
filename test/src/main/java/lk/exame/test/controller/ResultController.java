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

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/result")
public class ResultController {

	@Autowired
	private ResultService resultService;
	
	@GetMapping(value = "/findResult/{exameId}")
	private ResponseEntity<Object>findResultExameId(@PathVariable Integer exameId)throws Exception{
		
		return new ResponseEntity<Object>(resultService.findByExameId(exameId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/findResultUserName/{userName}")
	private ResponseEntity<Object>findResultQuesName(@PathVariable String userName)throws Exception{
		return new ResponseEntity<Object>(resultService.findByUserName(userName),HttpStatus.OK);
				
	}
}
