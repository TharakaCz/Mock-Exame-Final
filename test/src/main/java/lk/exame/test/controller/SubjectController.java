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


@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/sub")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping(value = "/saveSubject")
	public ResponseEntity<Object>save(@RequestBody SubjectDTO subjectDTO)throws Exception{
		return new ResponseEntity<Object>(subjectService.save(subjectDTO),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleSub/{subId}")
	public boolean delete(@PathVariable Integer subId)throws Exception{
		return subjectService.delete(subId);
	}
	
	@GetMapping(value="/find/{subId}")
	public SubjectDTO findSubject(@PathVariable Integer subId)throws Exception{
		return subjectService.findSubject(subId);
	}
	
	@GetMapping(value="/getAllSubject")
	public ArrayList<SubjectDTO>getAllSubject()throws Exception{
		return subjectService.getAllSubject();
	}
}
