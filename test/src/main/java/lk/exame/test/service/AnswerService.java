package lk.exame.test.service;

import java.util.List;

import lk.exame.test.dto.AnswersDTO;

public interface AnswerService {

	public boolean save(AnswersDTO answersDTO)throws Exception;
	
	public boolean delete(Integer answerId)throws Exception;
	
	public List<AnswersDTO> getAnswers(Integer questionId)throws Exception;
	
	public AnswersDTO getAnswer(Integer answerId)throws Exception;
	
	public List<AnswersDTO> getQuestions(Integer quesId)throws Exception;
}
