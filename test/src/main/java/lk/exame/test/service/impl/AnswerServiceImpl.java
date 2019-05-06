package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dto.AnswersDTO;
import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.repository.AnswerRepository;
import lk.exame.test.repository.QuestionRepository;
import lk.exame.test.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerRepository repository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public boolean save(AnswersDTO answersDTO) throws Exception {
		
		repository.save(getAnswerEntity(answersDTO));
		return true;
	}
	
	private AnswerEntity getAnswerEntity(AnswersDTO answersDTO)throws Exception{
		
		QuestionEntity questionEntity=questionRepository.getOne(answersDTO.getQuestionId());
		
		AnswerEntity answerEntity = new AnswerEntity();
		answerEntity.setAnsewer(answersDTO.getAnsewer());
		answerEntity.setCorrect(answerEntity.getCorrect());
		answerEntity.setQuestionEntity(questionEntity);
		
		return answerEntity;
	}

	@Override
	public List<AnswersDTO> getAnswers(Integer questionId) throws Exception {
	
		QuestionEntity questionEntity=questionRepository.getOne(questionId);
		
		List<AnswerEntity>getAll=repository.findAllByQuestionEntity(questionEntity);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AnswersDTO getAnswer(Integer answerId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnswersDTO> getQuestions(Integer quesId) throws Exception {
	
		List<AnswerEntity>answerList = repository.getAnswers(quesId);
		
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
