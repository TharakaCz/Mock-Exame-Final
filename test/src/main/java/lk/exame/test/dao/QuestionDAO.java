package lk.exame.test.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;

public interface QuestionDAO extends CrudRepository<QuestionEntity, Integer>{

	  List<QuestionEntity>findAllByQuestionLeval(String questionLeval);
	
	  QuestionEntity findOneByQuestion(String question);
	
	  List<QuestionEntity> findAllByStatus(String status);
	  
	  ArrayList<QuestionEntity> findAllQuesIdByQuestionLevalAndStatusAndLanguageEntitiey(String questionLeval,String status,LanguageEntity languageEntity);
	  
	  ArrayList<QuestionEntity>findAllQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndQuesIdNotIn(String questionLeval,String status,LanguageEntity languageEntity,List<Integer>questionIds);
}
