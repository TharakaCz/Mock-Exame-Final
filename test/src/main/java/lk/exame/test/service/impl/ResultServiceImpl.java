package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.ExamDAO;
import lk.exame.test.dao.ResultDAO;
import lk.exame.test.dto.ResultDTO;
import lk.exame.test.entity.ExamEntity;
import lk.exame.test.entity.ResultEntity;
import lk.exame.test.service.ResultService;

/**
 * 
 * @author Tharaka Chandralal
 */
@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDAO resultDao;

	@Autowired
	private ExamDAO examDao;
	
	/*
	 * (non-Javadoc)
	 * Find Result In Result Table Using Exam Id
	 * @see lk.exam.test.service.ResultService#findByExamId(java.lang.Integer)
	 */
	@Override
	public ResultDTO findByExamId(Integer examId) throws Exception {
		System.out.println("Exam id . . /"+examId);
		
		ExamEntity entities =  examDao.findByExamId(examId);
		
		
		
		System.out.println(entities == null);
		
		ExamEntity examEntity = examDao.findByExamId(examId);
		
		  Integer resultId = examEntity.getResultEntity().getResultId(); ResultEntity
		  resultEntity = resultDao.findByResultId(resultId);
		  
		  ResultDTO resultDTO = new ResultDTO();
		  
		  
		  resultDTO.setTotal(resultEntity.getTotal());
		  resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		  resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		 
		  
		  return resultDTO;
		 

	}

	/*
	 * (non-Javadoc)
	 * 
	 * Find Result In Result Table Using UserName
	 * 
	 * @see lk.exame.test.service.ResultService#findByUserName(java.lang.String)
	 */
	@Override
	public ArrayList<ResultDTO> findByUserName(String userName) throws Exception {

		List<ResultEntity> resultEntities = resultDao.findAllByUserNameOrderByExamDateDesc(userName);

		ArrayList<ResultDTO> resultDTOs = new ArrayList<ResultDTO>();

		resultEntities.forEach(e -> {
			
			resultDTOs.add(getResult(e));
			
		});

		return resultDTOs;
	}

	private ResultDTO getResult(ResultEntity resultEntity) {

		
		  ResultDTO resultDTO = new ResultDTO();
		  
		  resultDTO.setResultId(resultEntity.getResultId());
		  
		  resultDTO.setTotal(resultEntity.getTotal());
		  resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		  resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		  resultDTO.setUserName(resultEntity.getUserName());
		  resultDTO.setExamDate(resultEntity.getExamDate());
		
		 

		return resultDTO;
	}

}
