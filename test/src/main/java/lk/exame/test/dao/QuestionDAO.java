package lk.exame.test.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;

public interface QuestionDAO extends CrudRepository<QuestionEntity, Integer>{

	  List<QuestionEntity>findAllByQuestionLeval(String questionLeval);
	
	  
	/*
	 * @Query(value
	 * ="SELECT * FROM question where question_leval =\"Easy\" and status=\"active\" and language_id =:lang order by rand() limit 1"
	 * ,nativeQuery = true) QuestionEntity getPrimatyStage(@Param("lang")Integer
	 * languageId);
	 */
	  
	/*
	 * @Query("SELECT e FROM QuestionEntity e WHERE e.languageEntity=:lang and e.status=:stat and e.questionLeval=:quesLeval ORDER BY RAND()"
	 * ) QuestionEntity getPrimary(@Param("lang")LanguageEntity
	 * languageEntity,@Param("stat")String status,@Param("quesLeval")String
	 * questionLeval);
	 */
	  
	/*
	 * @Query("SELECT e From QuestionEntity e WHERE e.languageEntitiey=:lang and e.questionLeval=:quesLvl and e.status=:stat"
	 * ) List<QuestionEntity> getQuesId(@Param("lang")LanguageEntity
	 * languageEntity,@Param("quesLvl")String questionLeval,@Param("stat")String
	 * stat);
	 */
	  
//	  QuestionEntity findTop1ByLanguageEntitieyAndQuestionLevalAndStatusQuesIdNotIn(LanguageEntity languageEntity,String questionLeval,String status,List<Integer>questionIds);
	
	/*
	 * QuestionEntity
	 * getTop1ByLanguageEntitieyAndQuestionLevalAndStatusNotIn(LanguageEntity
	 * languageEntity,String questionLeval,String status,List<Integer>quaryNum);
	 */
	  
	  /*
	 * QuestionEntity findOneByQuestionLevalAndStatusAndLanguageEntitiey(String
	 * questionLeval,String status ,LanguageEntity languageEntity);
	 */
	
	  QuestionEntity findOneByQuestion(String question);
	  
	  
	 
	/*
	 * @Query(value
	 * ="SELECT * FROM question where question_leval =\"Easy\" and status=\"active\" and language_id =:lang and ques_id not in(:id) order by rand() limit 1 "
	 * ,nativeQuery = true) QuestionEntity
	 * getEasyQuestions(@Param("id")List<Integer>quaryNum,@Param("lang")Integer
	 * languageId);
	 */
	  
	/*
	 * QuestionEntity findOneByQuestionLevalAndStatusAndLanguageEntitieyNotIn(String
	 * questionLeval,String status ,LanguageEntity
	 * languageEntity,List<Integer>quaryNum);
	 */
	  
	/*
	 * @Query(value
	 * ="SELECT * FROM question where question_leval =\"Normal\" and status=\"active\" and language_id =:lang and ques_id not in(:id)  order by rand() limit 1"
	 * ,nativeQuery = true) QuestionEntity
	 * getNormalQuestions(@Param("id")List<Integer>quaryNum,@Param("lang")Integer
	 * languageId);
	 * 
	 * @Query(value
	 * ="SELECT * FROM question where question_leval =\"Hard\" and status=\"active\" and language_id =:lang and ques_id not in(:id) order by rand() limit 1"
	 * ,nativeQuery = true) QuestionEntity
	 * getHardQuestions(@Param("id")List<Integer>quaryNum,@Param("lang")Integer
	 * languageId);
	 * 
	 * @Query(value ="SELECT * FROM question where ques_id=:id",nativeQuery=true)
	 * QuestionEntity getBackQuestions(@Param("id")Integer quesId);
	 */
	  
	  List<QuestionEntity> findAllByStatus(String status);
	  
	  ArrayList<QuestionEntity> findAllQuesIdByQuestionLevalAndStatusAndLanguageEntitiey(String questionLeval,String status,LanguageEntity languageEntity);
	  
	  ArrayList<QuestionEntity>findAllQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndQuesIdNotIn(String questionLeval,String status,LanguageEntity languageEntity,List<Integer>questionIds);
}
