package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.LanguageDAO;
import lk.exame.test.dto.LanguageDTO;
import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	private LanguageDAO languageDao;
	
	
	/*
	 * @Override public boolean save(LanguageDTO languageDTO) throws Exception {
	 * 
	 * QuestionEntity questionEntity=
	 * questionRepository.getOne(languageDTO.getQuestionId());
	 * 
	 * LanguageEntity language= new LanguageEntity();
	 * language.setLangName(languageDTO.getLangName());
	 * language.setQuestionEntity(questionEntity);
	 * 
	 * langRepository.save(language); return true; }
	 */

	@Override
	public boolean delete(Integer langId) throws Exception {
		languageDao.deleteById(langId);
		return true;
	}

	@Override
	public boolean edit(LanguageDTO languageDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.LanguageService#save(lk.exame.test.dto.LanguageDTO)
	 */
	@Override
	public boolean save(LanguageDTO languageDTO) throws Exception {
		
		LanguageEntity languageEntity = new LanguageEntity();
		
		languageEntity.setLangName(languageDTO.getLangName());
		
		languageDao.save(languageEntity);
		
		return true;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.LanguageService#getAllLanguage()
	 */
	@Override
	public ArrayList<LanguageDTO> getAllLanguage() {
		
		List<LanguageEntity>getLanguages = (List<LanguageEntity>) languageDao.findAll();
		
		ArrayList<LanguageDTO>languageDTOs = new ArrayList<>();
		
		getLanguages.forEach(e->{
			languageDTOs.add(getLanguages(e));
		});
		
		return languageDTOs;
	}

	/*
	 * @Override public LanguageDTO getLanguage(Integer langId) throws Exception {
	 * 
	 * LanguageEntity language = langRepository.findById(langId).get();
	 * 
	 * LanguageDTO languageDTO = new
	 * LanguageDTO(language.getLangId(),language.getLangName(),language.
	 * getQuestionEntity().getQuesId()); return languageDTO; }
	 */

	/*
	 * @Override public ArrayList<LanguageDTO> getAllLanguage() {
	 * List<LanguageEntity>languages = langRepository.findAll();
	 * 
	 * ArrayList<LanguageDTO>languageDTOs = new ArrayList<>();
	 * 
	 * for(LanguageEntity language : languages) { LanguageDTO languageDTO = new
	 * LanguageDTO( language.getLangId(),
	 * language.getLangName(),language.getQuestionEntity().getQuesId() );
	 * languageDTOs.add(languageDTO); } return languageDTOs; }
	 */

	private LanguageDTO getLanguages(LanguageEntity languageEntity){
		
		LanguageDTO  languageDTO = new LanguageDTO();
		
		languageDTO.setLangId(languageEntity.getLangId());
		languageDTO.setLangName(languageEntity.getLangName());
		
		return languageDTO;
	}
}
