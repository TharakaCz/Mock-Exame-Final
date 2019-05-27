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

import lk.exame.test.dto.LanguageDTO;
import lk.exame.test.service.LanguageService;

/**
 * 
 * @author Tharaka Chandralal
 */
@RequestMapping(value ="/api/v1/lang")
@RestController
@CrossOrigin
public class LanguageController {

	@Autowired
	private LanguageService langService;
	
	@PostMapping(value="/saveLanguage")
	private ResponseEntity<Object>saveLanguage(@RequestBody LanguageDTO languageDTO){
		try {
			return new ResponseEntity<Object>(langService.save(languageDTO),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllLanguages")
	private ResponseEntity<Object>getAllLanguages(){
		try {
			return new ResponseEntity<Object>(langService.getAllLanguage(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deleteLanguage/{langId}")
	private ResponseEntity<Object>deleteLanguage(@PathVariable Integer langId){
		try {
			return new  ResponseEntity<Object>(langService.delete(langId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/searchLanguage/{langId}")
	private ResponseEntity<Object>searchLanguage(@PathVariable Integer langId){
		
		try {
			return new ResponseEntity<Object>(langService.searchLanguage(langId),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/editLanguage")
	private ResponseEntity<Object>editLanguage(@RequestBody LanguageDTO languageDTO){
		try {
			return new ResponseEntity<Object>(langService.edit(languageDTO),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
