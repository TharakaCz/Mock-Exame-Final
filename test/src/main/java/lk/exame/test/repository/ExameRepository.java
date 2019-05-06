package lk.exame.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lk.exame.test.entity.ExameEntity;

public interface ExameRepository extends JpaRepository<ExameEntity, Integer>{

	@Query(value = "SELECT * FROM exame where user_name=:user",nativeQuery=true)
	ExameEntity getByUserName(@Param("user")String userName);
	
	@Query(value = "SELECT * FROM exame where user_name=:user",nativeQuery= true)
	List<ExameEntity>findByUserNameList(@Param("user")String userName);
	

}
