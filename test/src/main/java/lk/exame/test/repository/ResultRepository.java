package lk.exame.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lk.exame.test.entity.ResultEntity;

public interface ResultRepository extends JpaRepository<ResultEntity, Integer>{

	@Query(value = "SELECT * FROM result where user_name =:user",nativeQuery=true)
	List<ResultEntity> getResult(@Param("user")String userName);
	
	@Query(value = "SELECT * FROM result where exame_id=:id",nativeQuery=true)
	ResultEntity getByExameId(@Param("id")Integer exameId);
	
	@Query(value = "SELECT * FROM result where result_id=:id",nativeQuery=true)
	ResultEntity getByResultId(@Param("id")Integer ResultIdInExameEntity);
	
	
}
