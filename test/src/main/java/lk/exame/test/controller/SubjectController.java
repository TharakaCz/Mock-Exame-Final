package lk.exame.test.controller;

import java.util.ArrayList;

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

import lk.exame.test.dto.SubjectDTO;
import lk.exame.test.service.SubjectService;

/**
 * 
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/sub")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping(value = "/saveSubject")
	public ResponseEntity<Object>save(@RequestBody SubjectDTO subjectDTO){
		try {
			return new ResponseEntity<Object>(subjectService.save(subjectDTO),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deleSub/{subId}")
	public ResponseEntity<Object> delete(@PathVariable Integer subId){
		
		try {
			return new ResponseEntity<Object>(subjectService.delete(subId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/find/{subId}")
	public ResponseEntity<Object>findSubject(@PathVariable Integer subId){
		try {
			return new ResponseEntity<Object>(subjectService.findSubject(subId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*
	 * public SubjectDTO findSubject(@PathVariable Integer subId)throws Exception{
	 * return subjectService.findSubject(subId); }
	 */
	
	@GetMapping(value="/getAllSubject")
	public ResponseEntity<Object>getAllSubject(){
		try {
			return new ResponseEntity<Object>(subjectService.getAllSubject(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*public ArrayList<SubjectDTO>getAllSubject()throws Exception{
		return subjectService.getAllSubject();
	}*/
}
