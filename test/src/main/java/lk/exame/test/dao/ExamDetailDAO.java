package lk.exame.test.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import lk.exame.test.entity.ExamDetailsEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface ExamDetailDAO extends JpaRepository<ExamDetailsEntity, Integer>{

}
