package lk.exame.test.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.exame.test.entity.ResultEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface ResultDAO extends JpaRepository<ResultEntity, Integer>{

	List<ResultEntity> findAllByUserNameOrderByExamDateDesc(String userName);
	
	ResultEntity findByResultId(Integer resultId);
	
	List<ResultEntity>findAllByStatusAndUserNameAndExamDateBetween(String status,String userName,Date date1,Date date2);
	
	
}
