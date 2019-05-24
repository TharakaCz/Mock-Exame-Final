package lk.exame.test.dao;


import org.springframework.data.repository.CrudRepository;

import lk.exame.test.entity.ExamDetailsEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface ExamDetailDAO extends CrudRepository<ExamDetailsEntity, Integer>{

}
