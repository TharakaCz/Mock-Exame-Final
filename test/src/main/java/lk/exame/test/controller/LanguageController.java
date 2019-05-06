package lk.exame.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.exame.test.dto.LanguageDTO;
import lk.exame.test.service.LanguageService;

@RequestMapping(value ="/api/v1/lang")
@RestController
@CrossOrigin
public class LanguageController {

	@Autowired
	private LanguageService langService;
	
	@PostMapping(value="/saveLanguage")
	private ResponseEntity<Object>saveLanguage(@RequestBody LanguageDTO languageDTO)throws Exception{
		return new ResponseEntity<Object>(langService.save(languageDTO),HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllLanguages")
	private ResponseEntity<Object>getAllLanguages()throws Exception{
		return new ResponseEntity<Object>(langService.getAllLanguage(),HttpStatus.OK);
	}
}
