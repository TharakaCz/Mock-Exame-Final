package lk.exame.test.service;

import java.util.ArrayList;
import java.util.List;

import lk.exame.test.dto.ExamDTO;
import lk.exame.test.dto.ExamDetailsDTO;
import lk.exame.test.dto.ExamBasicDetailDTO;
import lk.exame.test.dto.ResultDTO;
import lk.exame.test.dto.SubmitQuestionDTO;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface ExamService {
	

	public boolean delete(Integer examId)throws Exception;
	

	public ResultDTO getExamResult(Integer examId)throws Exception;
	
	/*
	 * public QuestionsDTO getQuestion(List<Integer> questionIds,Integer
	 * languageId)throws Exception;
	 */
	
	public ExamBasicDetailDTO returnBacicDetails(ExamBasicDetailDTO examBasicDetailDTO)throws Exception;
	
	public ResultDTO submitQuestion(List<SubmitQuestionDTO>submitQuestionDTOs,String userName , Integer languageId)throws Exception;
	
	public ArrayList<ExamDTO> getExamId(String userName)throws Exception;
	
	public ArrayList<ResultDTO> getResultByExamUserName(String userName)throws Exception;
	
	
}
