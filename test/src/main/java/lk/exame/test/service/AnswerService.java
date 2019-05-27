package lk.exame.test.service;

import java.util.List;

import lk.exame.test.dto.AnswersDTO;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface AnswerService {

	
	public boolean delete(Integer answerId)throws Exception;
	
	public List<AnswersDTO> getAnswers(Integer questionId)throws Exception;
	

	
	public List<AnswersDTO> getQuestions(Integer quesId)throws Exception;
}
