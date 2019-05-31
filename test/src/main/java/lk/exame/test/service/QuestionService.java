package lk.exame.test.service;

import java.util.ArrayList;
import java.util.List;


import lk.exame.test.dto.QuestionsDTO;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface QuestionService {

	public boolean update(QuestionsDTO questionsDTO) throws Exception;

	public QuestionsDTO edit(Integer quesId) throws Exception;

	public boolean delete(Integer quesId) throws Exception;

	public QuestionsDTO getQuestion(List<Integer> questionIds, Integer languageId, Integer subjectId) throws Exception;

	public boolean saveQuestionAnswer(QuestionsDTO questionsDTO) throws Exception;

	public ArrayList<QuestionsDTO> getAllQuestions() throws Exception;

	public ArrayList<QuestionsDTO> getAllQuestionInLanguage(Integer languageId) throws Exception;

	public ArrayList<QuestionsDTO> getAllQuestionInSubject(Integer subjectId) throws Exception;

	public ArrayList<QuestionsDTO> getAllQuestionInLanguageAndSubject(Integer languageId, Integer subjectId)
			throws Exception;

	
	  public ArrayList<QuestionsDTO>getAllQuestionInLanguageOrSubject(Integer
	  languageId,Integer subjectId)throws Exception;
	 

}
