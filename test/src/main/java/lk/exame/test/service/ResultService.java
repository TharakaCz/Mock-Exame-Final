package lk.exame.test.service;

import java.util.ArrayList;

import lk.exame.test.dto.ResultDTO;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface ResultService {
	
	public ResultDTO findByExamId(Integer examId)throws Exception;
	
	public ArrayList<ResultDTO> findByUserName(String userName)throws Exception;
}
