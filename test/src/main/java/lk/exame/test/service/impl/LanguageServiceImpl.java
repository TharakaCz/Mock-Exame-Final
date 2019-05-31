package lk.exame.test.service.impl;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.LanguageDAO;
import lk.exame.test.dao.QuestionDAO;
import lk.exame.test.dto.LanguageDTO;
import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.service.LanguageService;
import lk.exame.test.utill.AppConstant;

/**
 * 
 * @author Tharaka Chandralal
 */
@Service
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	private LanguageDAO languageDao;
	
	@Autowired
	private QuestionDAO questionDao;
	
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

	/**
	 * This Method using Active Row Deactivate In Language Table
	 */
	@Override
	public boolean delete(Integer langId) throws Exception {
		
		LanguageEntity languageEntity = languageDao.findByLangId(langId);
		QuestionEntity questionEntity = questionDao.findOneByLanguageEntitiey(languageEntity);
		
		languageEntity.setStatus(AppConstant.DEACTIVE);
		questionEntity.setStatus(AppConstant.DEACTIVE);
		
		if (languageEntity != null) {
			
			languageDao.save(languageEntity);
			questionDao.save(questionEntity);
			
		}
		
		return true;
	}

	@Override
	public boolean edit(LanguageDTO languageDTO) throws Exception {

		LanguageEntity languageEntity = languageDao.findByLangId(languageDTO.getLangId());
		
		String encodeLanguage = URLEncoder.encode(languageEntity.getLangName(),"UTF-8");
		languageEntity.setLangName(encodeLanguage);
		
		languageDao.save(languageEntity);
		
		return true;
	}

	/* (non-Javadoc)
	 * 
	 * This Method Using Save Language In Language Table
	 * 
	 * @see lk.exame.test.service.LanguageService#save(lk.exame.test.dto.LanguageDTO)
	 */
	@Override
	public boolean save(LanguageDTO languageDTO) throws Exception {
		
		LanguageEntity languageEntity = new LanguageEntity();
		
		String encodeLanguage = URLEncoder.encode(languageDTO.getLangName(),"UTF-8");
		
		languageEntity.setLangName(encodeLanguage);
		languageEntity.setStatus(AppConstant.ACTIVE);
		
		languageDao.save(languageEntity);
		
		return true;
	}

	/* (non-Javadoc)
	 * 
	 * This are Using Get All Languages In Language Table
	 * 
	 * @see lk.exame.test.service.LanguageService#getAllLanguage()
	 */
	@Override
	public ArrayList<LanguageDTO> getAllLanguage()throws Exception {
		
		String status = AppConstant.ACTIVE;
		
		List<LanguageEntity>getLanguages = languageDao.findAllByStatus(status);
		
		ArrayList<LanguageDTO>languageDTOs = new ArrayList<>();
		
		getLanguages.forEach(e->{
			try {
				languageDTOs.add(getLanguages(e));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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

	private LanguageDTO getLanguages(LanguageEntity languageEntity)throws Exception{
		
		LanguageDTO  languageDTO = new LanguageDTO();
		
		String decodeLanguage = URLDecoder.decode(languageEntity.getLangName(),"UTF-8");
		
		languageDTO.setLangId(languageEntity.getLangId());
		languageDTO.setLangName(decodeLanguage);
		
		return languageDTO;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.LanguageService#searchLanguage(java.lang.Integer)
	 */
	@Override
	public LanguageDTO searchLanguage(Integer langId) throws Exception {
		
		LanguageEntity languageEntity = languageDao.findByLangId(langId);
		
		LanguageDTO languageDTO = new LanguageDTO();
		
		String languageDecoder = URLDecoder.decode(languageEntity.getLangName(),"UTF-8");
		
		languageDTO.setLangId(languageEntity.getLangId());
		languageDTO.setLangName(languageDecoder);
		
		
		return languageDTO;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.LanguageService#getAllDeactiveQuestions()
	 */
	@Override
	public ArrayList<LanguageDTO> getAllDeactiveQuestions() throws Exception {
		
		List<LanguageEntity>languageList = languageDao.findAllByStatus(AppConstant.DEACTIVE);
		
		ArrayList<LanguageDTO>languageDTOs = new ArrayList<LanguageDTO>();
		
		languageList.forEach(each->{
			try {
				languageDTOs.add(getLanguages(each));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return languageDTOs;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.LanguageService#activeDeactiveLanguage(java.lang.Integer)
	 */
	@Override
	public String activeDeactiveLanguage(Integer languageId) throws Exception {
		
		LanguageEntity languageEntity = languageDao.findByLangId(languageId);
		QuestionEntity questionEntity = questionDao.findOneByLanguageEntitiey(languageEntity);
		String status = AppConstant.ACTIVE;
		
		if (languageEntity != null) {
			languageEntity.setStatus(status);
			questionEntity.setStatus(status);
			
			languageDao.save(languageEntity);
			questionDao.save(questionEntity);
			
			return "Language Succsessfully Activated . . !";
		}else {
			return "Activetion Error Please Try Again . . !";
		}
	}
}
