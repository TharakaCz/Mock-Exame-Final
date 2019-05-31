package lk.exame.test.dao;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.exame.test.entity.LanguageEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface LanguageDAO extends JpaRepository<LanguageEntity, Integer>{

	LanguageEntity findByLangId(Integer langId);
	
	List<LanguageEntity>findAllByStatus(String status);
	
	LanguageEntity findOneByLangId(Integer languageId);
	

}
