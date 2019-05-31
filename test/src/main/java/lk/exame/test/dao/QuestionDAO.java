package lk.exame.test.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.SubjectEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface QuestionDAO extends JpaRepository<QuestionEntity, Integer>{

	  List<QuestionEntity>findAllByQuestionLeval(String questionLeval);
	
	  QuestionEntity findByQuesId(Integer quesId);
	  
	  QuestionEntity findOneByQuestion(String question);
	
	  List<QuestionEntity> findAllByStatus(String status);
	  
	  List<QuestionEntity>findAllByStatusAndLanguageEntitiey(String status,LanguageEntity languageEntity);
	  
	  List<QuestionEntity>findAllByStatusAndSubjectEntitiy(String status,SubjectEntity subjectEntity);
	  
	  List<QuestionEntity>findAllByStatusAndSubjectEntitiyAndLanguageEntitiey(String status,SubjectEntity subjectEntity,LanguageEntity languageEntity);
	  
	  List<QuestionEntity>findAllByStatusAndSubjectEntitiyOrLanguageEntitiey(String status,SubjectEntity subjectEntity , LanguageEntity languageEntity);
	  
	  ArrayList<QuestionEntity> findOneQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndSubjectEntitiy(String questionLeval,String status,LanguageEntity languageEntity,SubjectEntity subjectEntity);
	  
	  ArrayList<QuestionEntity>findOneQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndSubjectEntitiyAndQuesIdNotIn(String questionLeval,String status,LanguageEntity languageEntity,SubjectEntity subjectEntity,List<Integer>questionIds);
	  
	 QuestionEntity findOneByLanguageEntitiey(LanguageEntity languageEntity);
	 
	 QuestionEntity findOneBySubjectEntitiy(SubjectEntity subjectEntity);
}
