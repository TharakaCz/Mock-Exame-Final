package lk.exame.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lk.exame.test.entity.ExamEntity;

/**    
 * 
 * @author Tharaka Chandralal
 */
public interface ExamDAO extends CrudRepository<ExamEntity, Integer>{

	List<ExamEntity>findByUserNameAndStatus(String userName,String status);
	
	ExamEntity findFirst1ByExamId(Integer examId);

	/**
	 * @param exameId
	 * @return
	 */
	ExamEntity findOneByExamId(Integer examId);

	/**
	 * @param exameId
	 * @return
	 */
	ExamEntity findByExamId(Integer examId);
	
	
	List<ExamEntity> findAllByOrderByExamDateDesc();

}
