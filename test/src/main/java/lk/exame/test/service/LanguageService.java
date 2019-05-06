package lk.exame.test.service;

import java.util.ArrayList;

import lk.exame.test.dto.LanguageDTO;

public interface LanguageService {

	public boolean save(LanguageDTO languageDTO)throws Exception;
	
	public boolean delete(Integer langId)throws Exception;
	
	public boolean edit(LanguageDTO languageDTO)throws Exception;
	
	/* public LanguageDTO getLanguage(Integer langId)throws Exception; */
	
	public ArrayList<LanguageDTO>getAllLanguage();
}
