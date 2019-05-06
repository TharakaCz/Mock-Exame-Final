package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dto.ResultDTO;
import lk.exame.test.entity.ResultEntity;
import lk.exame.test.repository.ResultRepository;
import lk.exame.test.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepository resultRepository;

	/*
	 * @Override public ResultDTO findResult(String userName) throws Exception {
	 * 
	 * ResultEntity resultEntity = resultRepository.getResult(userName); ResultDTO
	 * resultDTO = new ResultDTO();
	 * 
	 * resultDTO.setUserName(resultEntity.getUserName());
	 * resultDTO.setExameId(resultEntity.getExameId());
	 * resultDTO.setLanguage(resultEntity.getLanguage());
	 * resultDTO.setTotal(resultEntity.getTotal());
	 * resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
	 * resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
	 * 
	 * return resultDTO;
	 * 
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.exame.test.service.ResultService#findByExameId(java.lang.Integer)
	 */
	@Override
	public ResultDTO findByExameId(Integer exameId) throws Exception {

		  ResultEntity resultEntity = resultRepository.getByExameId(exameId);
		  
		  ResultDTO resultDTO = new ResultDTO();
		  
		 
		  resultDTO.setTotal(resultEntity.getTotal());
		  resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		  resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		  
		  return resultDTO;
		 

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.exame.test.service.ResultService#findByUserName(java.lang.String)
	 */
	@Override
	public ArrayList<ResultDTO> findByUserName(String userName) throws Exception {

		List<ResultEntity> resultEntities = resultRepository.getResult(userName);

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
		  resultDTO.setStartTime(resultEntity.getStartTime());
		  
		  resultDTO.setEndTime(resultEntity.getEndTime());
		  resultDTO.setExameDate(resultEntity.getExameDate());
		
		 

		return null;
	}

}
