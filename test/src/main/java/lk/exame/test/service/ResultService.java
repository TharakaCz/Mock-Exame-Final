package lk.exame.test.service;

import java.util.ArrayList;

import lk.exame.test.dto.ResultDTO;

public interface ResultService {
	
	public ResultDTO findByExameId(Integer exameId)throws Exception;
	
	public ArrayList<ResultDTO> findByUserName(String userName)throws Exception;
}
