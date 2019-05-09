package lk.exame.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import lk.exame.test.entity.ExameEntity;

public interface ExameDAO extends CrudRepository<ExameEntity, Integer>{

	List<ExameEntity>findByUserNameAndStatus(String userName,String status);
	
	ExameEntity findFirst1ByExameId(Integer exameId);

	/**
	 * @param exameId
	 * @return
	 */
	ExameEntity findOneByExameId(Integer exameId);

	/**
	 * @param exameId
	 * @return
	 */
	ExameEntity findByExameId(Integer exameId);
	
	

}
