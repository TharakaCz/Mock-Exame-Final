package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.ExameDAO;
import lk.exame.test.dao.ResultDAO;
import lk.exame.test.dto.ResultDTO;
import lk.exame.test.entity.ExameEntity;
import lk.exame.test.entity.ResultEntity;
import lk.exame.test.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDAO resultDao;

	@Autowired
	private ExameDAO exameDao;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.exame.test.service.ResultService#findByExameId(java.lang.Integer)
	 */
	@Override
	public ResultDTO findByExameId(Integer exameId) throws Exception {
		System.out.println("Exame id . . /"+exameId);
		
		ExameEntity entities =  exameDao.findByExameId(exameId);
		
		
		
		System.out.println(entities == null);
		
		ExameEntity exameEntity = exameDao.findByExameId(exameId);
		
		System.out.println("Exame Id =/"+exameEntity.getExameId());
		
		
		  Integer resultId = exameEntity.getResultEntity().getResultId(); ResultEntity
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
	 * @see lk.exame.test.service.ResultService#findByUserName(java.lang.String)
	 */
	@Override
	public ArrayList<ResultDTO> findByUserName(String userName) throws Exception {

		List<ResultEntity> resultEntities = resultDao.findByUserName(userName);

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
		  
		  resultDTO.setExameDate(resultEntity.getExameDate());
		
		 

		return null;
	}

}
