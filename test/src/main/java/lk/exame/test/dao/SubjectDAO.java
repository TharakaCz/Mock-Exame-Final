package lk.exame.test.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.exame.test.entity.SubjectEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface SubjectDAO extends JpaRepository<SubjectEntity, Integer>{

	/**
	 * @param subjectId
	 * @return
	 */
	SubjectEntity findOneBySubId(Integer subjectId);

	List<SubjectEntity> findAllByStatus(String status);
	
	SubjectEntity findBySubId(Integer subjectId);
}
