package lk.exame.test.service;

import java.util.ArrayList;

import lk.exame.test.dto.LanguageDTO;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface LanguageService {

	public boolean save(LanguageDTO languageDTO)throws Exception;
	
	public boolean delete(Integer langId)throws Exception;
	
	public boolean edit(LanguageDTO languageDTO)throws Exception;
	
	public LanguageDTO searchLanguage(Integer langId)throws Exception;

	public ArrayList<LanguageDTO>getAllLanguage()throws Exception;
	
	public ArrayList<LanguageDTO>getAllDeactiveQuestions()throws Exception;
	
	public String activeDeactiveLanguage(Integer languageId)throws Exception;
}
