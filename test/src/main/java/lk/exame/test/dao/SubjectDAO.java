package lk.exame.test.dao;


import org.springframework.data.repository.CrudRepository;

import lk.exame.test.entity.SubjectEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface SubjectDAO extends CrudRepository<SubjectEntity, Integer>{

	/**
	 * @param subjectId
	 * @return
	 */
	SubjectEntity findOneBySubId(Integer subjectId);

	
}
