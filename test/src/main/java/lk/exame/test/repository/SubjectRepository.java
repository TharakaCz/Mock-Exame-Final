package lk.exame.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.SubjectEntity;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer>{

	/*
	 * List<SubjectEntity> findAllByQuestionEntity(QuestionEntity
	 * questionEntity)throws Exception;
	 */
	
	@Query(value ="SELECT * FROM subject where ques_id=:id", nativeQuery = true)
	SubjectEntity getSubject(@Param("id")Integer quesId);
	  
	 
	
}
