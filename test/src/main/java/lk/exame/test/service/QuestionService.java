package lk.exame.test.service;

import java.util.ArrayList;
import java.util.List;

import lk.exame.test.dto.QuestionsDTO;
import lk.exame.test.dto.ResultDTO;
import lk.exame.test.dto.SubmitQuestionDTO;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface QuestionService {

	
	public boolean update(QuestionsDTO questionsDTO)throws Exception;
	
	public QuestionsDTO edit(Integer quesId)throws Exception;
	
	public boolean delete(Integer quesId)throws Exception;
	
	public QuestionsDTO getQuestion(List<Integer> questionIds, Integer languageId)throws Exception;
	
	public ArrayList<QuestionsDTO>getAllQuestion()throws Exception;
	
	public boolean saveQuestionAnswer(QuestionsDTO questionsDTO)throws Exception;
	
	public ArrayList<QuestionsDTO>getAllQuestions()throws Exception;
	

	
	
}
