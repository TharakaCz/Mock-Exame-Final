package lk.exame.test.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lk.exame.test.dto.ReqDTO;
import lk.exame.test.entity.QuestionEntity;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer>{

	  List<QuestionEntity>findAllByQuestionLeval(String questionLeval);
	
	  @Query(value ="SELECT * FROM question where question_leval =\"Easy\" && status=\"active\" && language_id =:lang order by rand() limit 1",nativeQuery = true)
	  QuestionEntity getPrimatyStage(@Param("lang")Integer languageId);
	  
	  @Query(value ="SELECT * FROM question where question_leval =\"Easy\" && status=\"active\" && language_id =:lang && ques_id not in(:id) order by rand() limit 1 ",nativeQuery = true)
	  QuestionEntity getEasyQuestions(@Param("id")List<Integer>quaryNum,@Param("lang")Integer languageId);
	  
	  @Query(value ="SELECT * FROM question where question_leval =\"Normal\" && status=\"active\" && language_id =:lang && ques_id not in(:id)  order by rand() limit 1",nativeQuery = true)
	  QuestionEntity getNormalQuestions(@Param("id")List<Integer>quaryNum,@Param("lang")Integer languageId);
	  
	  @Query(value ="SELECT * FROM question where question_leval =\"Hard\" && status=\"active\" && language_id =:lang && ques_id not in(:id) order by rand() limit 1",nativeQuery = true)
	  QuestionEntity getHardQuestions(@Param("id")List<Integer>quaryNum,@Param("lang")Integer languageId);
	  
	  @Query(value ="SELECT * FROM question where ques_id=:id",nativeQuery=true)
	  QuestionEntity getBackQuestions(@Param("id")Integer quesId);

	  @Query(value = "SELECT * FROM question where status=\"active\"",nativeQuery = true)
	  List<QuestionEntity> getAllQuestions();
}
