package lk.exame.test.dao;




import org.springframework.data.repository.CrudRepository;


import lk.exame.test.entity.LanguageEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface LanguageDAO extends CrudRepository<LanguageEntity, Integer>{

	LanguageEntity findByLangId(Integer langId);
	
	
}
