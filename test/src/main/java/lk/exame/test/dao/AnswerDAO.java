package lk.exame.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.QuestionEntity;

public interface AnswerDAO extends CrudRepository<AnswerEntity, Integer>{
	
	List<AnswerEntity> findAllByQuestionEntity(QuestionEntity questionEntity)throws Exception;

	AnswerEntity findByAnswerId(Integer answerId);
	
	List<AnswerEntity> findByQuestionEntity(Integer quesId);
	
}
