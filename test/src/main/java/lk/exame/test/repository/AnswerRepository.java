package lk.exame.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.QuestionEntity;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer>{
	
	List<AnswerEntity> findAllByQuestionEntity(QuestionEntity questionEntity)throws Exception;

	
	@Query(value="SELECT * FROM answer where ques_id=:id",nativeQuery = true)
	List<AnswerEntity>getBackQiz(@Param("id")List<Integer> backIds)throws Exception;
	
	@Query(value = "SELECT * FROM answer where answer_id =:id",nativeQuery = true)
	List<AnswerEntity>getByAnswerId(@Param("id")List<Integer>answerId);
	
	@Query(value = "SELECT * FROM answer where ques_id=:id",nativeQuery = true)
	List<AnswerEntity>getAnswers(@Param("id")Integer quesId);
	
	@Query(value = "SELECT * FROM answer where ques_id=:id",nativeQuery = true)
	AnswerEntity findbyquesId(@Param("id") Integer quesId);
	
	@Query(value = "SELECT * FROM answer where answer_id=:id",nativeQuery = true)
	List<AnswerEntity>getListAnswer(@Param("id")Integer answerId);
}
