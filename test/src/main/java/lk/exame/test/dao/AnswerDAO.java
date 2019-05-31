package lk.exame.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.QuestionEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface AnswerDAO extends JpaRepository<AnswerEntity, Integer>{
	
	List<AnswerEntity> findAllByQuestionEntity(QuestionEntity questionEntity);

	AnswerEntity findByAnswerId(Integer answerId);
	
	List<AnswerEntity> findByQuestionEntity(Integer quesId);
	
	
}
