package lk.exame.test.service;

import java.util.ArrayList;
import java.util.List;

import lk.exame.test.dto.ExameDTO;
import lk.exame.test.dto.ExameDetailsDTO;
import lk.exame.test.dto.QuestionsDTO;
import lk.exame.test.dto.ResultDTO;
import lk.exame.test.dto.SubmitQuestionDTO;


public interface ExameService {

	public boolean delete(Integer exameId)throws Exception;
	
	public ExameDTO getExame(Integer exameId)throws Exception;
	
	public ArrayList<ExameDTO>getAllExame()throws Exception;
	
	public ResultDTO getExameResult(Integer exameId)throws Exception;
	
	public QuestionsDTO getQuestion(List<Integer> questionIds,Integer languageId)throws Exception;
	
	public List<ExameDetailsDTO>updateQuestion()throws Exception;
	
	public ResultDTO submitQuestion(List<SubmitQuestionDTO>submitQuestionDTOs,String userName , Integer languageId)throws Exception;
	
	public ArrayList<ExameDTO> getExameId(String userName)throws Exception;
	
	public ArrayList<ResultDTO> getResultByExameUserName(String userName)throws Exception;
	
	
}
