package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.AnswerDAO;
import lk.exame.test.dao.QuestionDAO;
import lk.exame.test.dto.AnswersDTO;
import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.service.AnswerService;
import lk.exame.test.utill.AppConstant;
/**
 * 
 * @author Tharaka Chandralal
 */
@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerDAO answerDao;
	
	@Autowired
	private QuestionDAO questionDao;
	
	/**
	 * Get All Answers From Answer Table From Database
	 */
	@Override
	public List<AnswersDTO> getAnswers(Integer questionId) throws Exception {
	
		QuestionEntity questionEntity=questionDao.findByQuesId(questionId);
		
		List<AnswerEntity>getAll=answerDao.findAllByQuestionEntity(questionEntity);
		List<AnswersDTO> getAlldto=new ArrayList<AnswersDTO>();
		
		getAll.forEach(e->{
			AnswersDTO answersDTO=new AnswersDTO();
			answersDTO.setAnswerId(e.getAnswerId());
			answersDTO.setAnsewer(e.getAnsewer());
			getAlldto.add(answersDTO);
		});
		
		return getAlldto;
	}

	@Override
	public boolean delete(Integer answerId) throws Exception {
		
		AnswerEntity answerEntity = answerDao.findByAnswerId(answerId);
		
		answerEntity.setStatus(AppConstant.DEACTIVE);
		if (answerEntity != null) {
			answerDao.save(answerEntity);
		}else {
			System.out.println("Answer Table Is Empty");
		}
		return false;
	}


	/**
	 * Find Question Using Question Id In AnswerTable
	 */
	@Override
	public List<AnswersDTO> getQuestions(Integer quesId) throws Exception {
	
		List<AnswerEntity>answerList = answerDao.findByQuestionEntity(quesId);
		
		List<AnswersDTO>answer = new ArrayList<>();

		answerList.forEach(e ->{
			try {
				answer.add(findAnswer(e));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		return answer;
	}
	
	
	private AnswersDTO findAnswer(AnswerEntity answerEntity)throws Exception{
		
		AnswersDTO answersDTO = new AnswersDTO();
		
		answersDTO.setAnswerId(answerEntity.getAnswerId());
		answersDTO.setAnsewer(answerEntity.getAnsewer());
		answersDTO.setTagName(answerEntity.getTagName());
		answersDTO.setCorrect(answerEntity.getCorrect());
		
		return answersDTO;
	}

}
