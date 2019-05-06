package lk.exame.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Integer>{

	@Query(value ="SELECT * FROM language where ques_id=:id", nativeQuery=true)
	LanguageEntity getLanguage(@Param("id") Integer quesId);
	
	
}
