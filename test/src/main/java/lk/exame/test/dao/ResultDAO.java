package lk.exame.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lk.exame.test.entity.ResultEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface ResultDAO extends CrudRepository<ResultEntity, Integer>{

	List<ResultEntity> findAllByUserName(String userName);
	
	ResultEntity findByResultId(Integer resultId);
	
	
	
	
}
