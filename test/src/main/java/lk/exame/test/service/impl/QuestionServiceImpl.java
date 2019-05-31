package lk.exame.test.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.AnswerDAO;
import lk.exame.test.dao.LanguageDAO;
import lk.exame.test.dao.QuestionDAO;
import lk.exame.test.dao.SubjectDAO;
import lk.exame.test.dto.AnswersDTO;
import lk.exame.test.dto.LanguageDTO;
import lk.exame.test.dto.QuestionsDTO;
import lk.exame.test.dto.SubjectDTO;
import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.SubjectEntity;
import lk.exame.test.service.QuestionService;
import lk.exame.test.utill.AppConstant;

/**
 * 
 * @author Tharaka Chandralal
 */
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDAO questionDao;

	@Autowired
	private AnswerDAO answerDao;

	@Autowired
	private LanguageDAO languageDao;

	@Autowired
	private SubjectDAO subjectDao;

	@Value("${app.easyStageStart}")
	private String easyStageStart;
	
	@Value("${app.easyStageEnd}")
	private String easyStageEnd;
	
	@Value("${app.normalStageStart}")
	private String normalStageStart;
	
	@Value("${app.normalStageEnd}")
	private String normalStageEnd;
	
	@Value("${app.hardStageStart}")
	private String hardStageStart;
	
	@Value("${app.hardStageEnd}")
	private String hardStageEnd;
	
	
	
	private Random random = new Random();
	
	private QuestionEntity questionEnt;

	/**
	 * This Method Using Active Row Deactivate From Question Table
	 * 
	 */
	@Override
	public boolean delete(Integer quesId) throws Exception {

		
		QuestionEntity questionEntity = questionDao.findByQuesId(quesId);

		questionEntity.setStatus(AppConstant.DEACTIVE);
		
		if (questionEntity != null) {

			questionDao.save(questionEntity);
		}else {
			System.out.println("Question Table Is Empty");
		}

		return true;
	}

	@Override
	public QuestionsDTO getQuestion(List<Integer> questionIds ,Integer languageId,Integer subjectId) throws Exception {

		LanguageEntity languageEntity = languageDao.findOneByLangId(languageId);
		SubjectEntity subjectEntity = subjectDao.findOneBySubId(subjectId);
		
		
		String questionLeval = "";
		String status = AppConstant.ACTIVE;

		System.out.println("SubjectEntity Exame Impl =/"+subjectEntity.getSubName());
		System.out.println("LanguageEntuty Exame Impl =/"+languageEntity.getLangName());
		QuestionsDTO questionsDTO = new QuestionsDTO();
		
		
		 Integer stageOneEnd = Integer.parseInt(easyStageEnd);
		 Integer stageTwoStart = Integer.parseInt(normalStageStart);
		 Integer stageTwoEnd = Integer.parseInt(normalStageEnd);
		 Integer stageThreeStart = Integer.parseInt(hardStageStart);
		 Integer stageThreeEnd = Integer.parseInt(hardStageEnd);
		
		
		if (questionIds == null || questionIds.size() >=0  && questionIds.size() <= stageOneEnd ) {
			
			questionLeval =  AppConstant.EASY;
		} else if (questionIds.size() >= stageTwoStart && questionIds.size() <= stageTwoEnd) {
			questionLeval = AppConstant.NORMAL;
		} else if (questionIds.size() >= stageThreeStart && questionIds.size() <= stageThreeEnd) {
			questionLeval = AppConstant.HARD;
		} else {
			System.out.println("SuccsessFully Compeated Exame");
			return null;
			
		} 

		ArrayList<QuestionEntity>questionEntit;
		
		
		if (questionIds == null || questionIds.size() == 0 ) {
			questionEntit = questionDao.findOneQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndSubjectEntitiy(questionLeval, status, languageEntity,subjectEntity);
		}else {
			questionEntit = questionDao.findOneQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndSubjectEntitiyAndQuesIdNotIn(questionLeval, status, languageEntity,subjectEntity, questionIds);
		}
		
		  if (questionEntit == null || questionEntit.size() == 0) {
		  
		  String newStatus = getStatus(questionLeval);
		  
		  if (newStatus == null || newStatus.isEmpty()) {
			  
		  System.out.println("Status Can't be Null");
		  
		  }else {
		  
		  if (questionIds == null || questionIds.size() == 0) {
		  
		  questionEntit =  questionDao.findOneQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndSubjectEntitiy(newStatus, status,languageEntity,subjectEntity);
		  }else { 
			  questionEntit = questionDao.findOneQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndSubjectEntitiyAndQuesIdNotIn(newStatus, status, languageEntity,subjectEntity, questionIds); 
			  }
		  } 
		  }
		  QuestionEntity
		  questionEntity=questionEntit.get(random.nextInt(questionEntit.size()));
		  questionEnt=questionDao.findByQuesId(questionEntity.getQuesId());
		
		List<AnswerEntity> getAnswersEasy = answerDao.findAllByQuestionEntity(questionEnt);
		List<AnswersDTO> getAllAnsweDto = new ArrayList<AnswersDTO>();

		getAnswersEasy.forEach(answersPrimary -> {
			System.out.println("Loop - 1");
			try {
				getAllAnsweDto.add(getAnswerDto(answersPrimary));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		questionsDTO.setQuesId(questionEnt.getQuesId());
		String decodeQuestion = URLDecoder.decode(questionEnt.getQuestion(),"UTF-8");
		questionsDTO.setQuestion(decodeQuestion);
		questionsDTO.setMarks(questionEnt.getMarks());

		questionsDTO.setQuestionLeval(questionEnt.getQuestionLeval());
		questionsDTO.setStatus(questionEnt.getStatus());

		questionsDTO.setAnswerDtos(getAllAnsweDto);

		return questionsDTO;
	}

	/**
	 * @param status
	 * @return
	 */
	private String getStatus(String questionLeval) {
		switch (questionLeval) {
		case AppConstant.EASY:
			return AppConstant.NORMAL;
			case AppConstant.NORMAL:
				return AppConstant.HARD;
				case AppConstant.HARD:
					return AppConstant.NORMAL;
					
		/*
		 * case AppConstant.HARD: return AppConstant.NORMAL; case AppConstant.NORMAL:
		 * return AppConstant.EASY;
		 */
		
		default:
			return AppConstant.EASY;
		}
	}
	

	/**
	 * This Method Using save Question And Answers In Question And Answer Tables
	 */
	@Override
	public boolean saveQuestionAnswer(QuestionsDTO questionsDTO) throws Exception {

		System.out.println("Impl subject id =/"+questionsDTO.getSubjectId());
		SubjectEntity subjectEntity = subjectDao.findOneBySubId(questionsDTO.getSubjectId());
		LanguageEntity languageEntity = languageDao.findByLangId(questionsDTO.getLanguageId());
				
		QuestionEntity questionEntity = new QuestionEntity();
		String encodeQuestion = URLEncoder.encode(questionsDTO.getQuestion(),"UTF-8");
		questionEntity.setQuestionQ(encodeQuestion);
		questionEntity.setQuestionLeval(questionsDTO.getQuestionLeval());
		questionEntity.setMarks(questionsDTO.getMarks());
		questionEntity.setSubjectEntitiy(subjectEntity);
		questionEntity.setLanguageEntitiey(languageEntity);
		questionEntity.setStatus(AppConstant.ACTIVE);
		QuestionEntity question = questionDao.save(questionEntity);

		if (question != null) {
			questionsDTO.getAnswerDtos().forEach(answers -> {
				
				try {
					String encodeAnswer = URLEncoder.encode(answers.getAnsewer(),"UTF-8");
					AnswerEntity answerEntity = new AnswerEntity();
	
					answerEntity.setAnsewer(encodeAnswer);
					answerEntity.setTagName(answers.getTagName());
					answerEntity.setCorrect(answers.getCorrect());;
					answerEntity.setStatus(AppConstant.ACTIVE);
					answerEntity.setQuestionEntity(question);
					answerDao.save(answerEntity);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			});
			 
			return true;
		}

		return true;
	}

	/**
	 * This Method Using Get All Questions From Question Table 
	 */
	@Override
	public ArrayList<QuestionsDTO> getAllQuestions() throws Exception {

		String status = AppConstant.ACTIVE;
		List<QuestionEntity> questionEntities = questionDao.findAllByStatus(status);
		ArrayList<QuestionsDTO> getAllQues = new ArrayList<>();

		questionEntities.forEach(e -> {

			try {
				getAllQues.add(getAllQuestion(e));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		System.out.println("AllQuestions =/" + getAllQues);

		return getAllQues;
	}

	/**
	 * This Method Using Update Question in Question Table
	 */
	@Override
	public boolean update(QuestionsDTO questionsDTO) throws Exception {

		QuestionEntity questionEntity = questionDao.findByQuesId(questionsDTO.getQuesId());
		
		SubjectEntity subjectEntity = subjectDao.findOneBySubId(questionsDTO.getSubjectDto().getSubId());
		
		LanguageEntity languageEntity = languageDao.findByLangId(questionsDTO.getLanguageDto().getLangId());

		if (questionEntity != null) {

			System.out.println("Ok");

			questionEntity.setQuestionQ(questionsDTO.getQuestion());
			questionEntity.setMarks(questionsDTO.getMarks());
			questionEntity.setQuestionLeval(questionsDTO.getQuestionLeval());
			
			questionEntity.setSubjectEntitiy(subjectEntity);
			questionEntity.setLanguageEntitiey(languageEntity);
			questionDao.save(questionEntity);

			questionsDTO.getAnswerDtos().forEach(answer -> {
				AnswerEntity answerEntity = answerDao.findByAnswerId(answer.getAnswerId());
				if (answerEntity != null) {
					answerEntity.setAnsewer(answer.getAnsewer());
					answerEntity.setTagName(answer.getTagName());
					answerEntity.setCorrect(answer.getCorrect());
				
					answerDao.save(answerEntity);
				}
			});


		} else {
			System.out.println("Problem Found . . . !");
		}

		return true;

	}

	
	
	/* (non-Javadoc)
	 * 
	 * This Method Using Edit  Question in Question Table Using Question Id
	 * 
	 * @see lk.exame.test.service.QuestionService#edit(java.lang.Integer)
	 */
	@Override
	public QuestionsDTO edit(Integer quesId) throws Exception {
		
		QuestionEntity questionEntity = new QuestionEntity();
		QuestionsDTO questionsDTO = new QuestionsDTO();
		
		  questionEntity = questionDao.findByQuesId(quesId);
		 
		  if (questionEntity != null) {
		  
		  System.out.println("Edit Works Id Passing . . . . ! ");
		  String decodeQuestion = URLDecoder.decode(questionEntity.getQuestion(),"UTF-8");
		  questionsDTO.setQuesId(questionEntity.getQuesId());
		  questionsDTO.setQuestion(decodeQuestion);
		  questionsDTO.setMarks(questionEntity.getMarks());
		  questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
		  questionsDTO.setSubjectDto(getSubjectDto(questionEntity.getSubjectEntitiy()));
		  questionsDTO.setLanguageDto(getLanguageDto(questionEntity.getLanguageEntitiey()));
		  questionsDTO.setStatus(questionEntity.getStatus());
			/*
			 * questionsDTO.setSubjectDto(); questionsDTO.setLanguageDto();
			 */
		  
		  List<AnswerEntity> getAnswersEasy =  answerDao.findAllByQuestionEntity(questionEntity);
		  List<AnswersDTO>  getAllAnsweDto = new ArrayList<>();
		
		  getAnswersEasy.forEach(answersPrimary -> {
		  try {
			getAllAnsweDto.add(getAnswerDto(answersPrimary));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  });
		  
		  questionsDTO.setAnswerDtos(getAllAnsweDto);
		 
		  
		  return questionsDTO;
		  
		  } else {
		  
		  System.out.println("Problem Occred . . . !");
		  } 
		  
		  return null;
		
	}
	
	private SubjectDTO getSubjectDto(SubjectEntity subjectEntity) throws Exception{
		
		SubjectDTO subjectDTO = new SubjectDTO();
		String decodeSubject = URLDecoder.decode(subjectEntity.getSubName(),"UTF-8");
		
		subjectDTO.setSubId(subjectEntity.getSubId());
		subjectDTO.setSubName(decodeSubject);
		
		return subjectDTO;
	}
	
	private LanguageDTO getLanguageDto(LanguageEntity languageEntity) throws Exception{
		
		LanguageDTO  languageDTO = new LanguageDTO();
		String decodeLanguage = URLDecoder.decode(languageEntity.getLangName(),"UTF-8");
		languageDTO.setLangId(languageEntity.getLangId());
		languageDTO.setLangName(decodeLanguage);
		
		return languageDTO;
	}
	
	private AnswersDTO getAnswerDto(AnswerEntity answerEntity) throws Exception{

		AnswersDTO answersDTO = new AnswersDTO();
		String answerDecoder = URLDecoder.decode(answerEntity.getAnsewer(),"UTF-8");
		
		answersDTO.setAnswerId(answerEntity.getAnswerId());
		answersDTO.setAnsewer(answerDecoder);
		answersDTO.setCorrect(answerEntity.getCorrect());
		answersDTO.setTagName(answerEntity.getTagName());
		answersDTO.setQuestionId(answerEntity.getQuestionEntity().getQuesId());

		return answersDTO;
	}
	
	

	/* (non-Javadoc)
	 * @see lk.exame.test.service.QuestionService#getAllQuestionInLanguage(java.lang.Integer)
	 */
	@Override
	public ArrayList<QuestionsDTO> getAllQuestionInLanguage(Integer languageId) throws Exception {
		
		String status = AppConstant.ACTIVE;
		
		LanguageEntity languageEntity = languageDao.findByLangId(languageId); 
		
		List<QuestionEntity>questionList = questionDao.findAllByStatusAndLanguageEntitiey(status, languageEntity);
		
		ArrayList<QuestionsDTO>questionDtoList = new ArrayList<QuestionsDTO>();
		
		questionList.forEach(each->{
			try {
				questionDtoList.add(getAllQuestion(each));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return questionDtoList;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.QuestionService#getAllQuestionInSubject(java.lang.Integer)
	 */
	@Override
	public ArrayList<QuestionsDTO> getAllQuestionInSubject(Integer subjectId) throws Exception {
		
		String status = AppConstant.ACTIVE;
		
		SubjectEntity subjectEntity = subjectDao.findBySubId(subjectId);
		
		List<QuestionEntity>questionList = questionDao.findAllByStatusAndSubjectEntitiy(status, subjectEntity);
		
		ArrayList<QuestionsDTO>quetionDtoList = new  ArrayList<QuestionsDTO>();
		
		questionList.forEach(each->{
			try {
				quetionDtoList.add(getAllQuestion(each));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		return quetionDtoList;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.QuestionService#getAllQuestionInLanguageAndSubject(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public ArrayList<QuestionsDTO> getAllQuestionInLanguageAndSubject(Integer languageId, Integer subjectId)
			throws Exception {
		
		String status = AppConstant.ACTIVE;
		
		SubjectEntity subjectEntity = subjectDao.findBySubId(subjectId);
		LanguageEntity languageEntity = languageDao.findByLangId(languageId);
		
		List<QuestionEntity>questionList = questionDao.findAllByStatusAndSubjectEntitiyAndLanguageEntitiey(status, subjectEntity, languageEntity);
		
		ArrayList<QuestionsDTO>questionDtoList = new ArrayList<QuestionsDTO>();
		
		questionList.forEach(each->{
			try {
				questionDtoList.add(getAllQuestion(each));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return questionDtoList;
	}
	


	private QuestionsDTO getAllQuestion(QuestionEntity questionEntity)throws Exception {

		
		QuestionsDTO questionsDTO = new QuestionsDTO();

		String decodeQuestion = URLDecoder.decode(questionEntity.getQuestion(),"UTF-8");
		questionsDTO.setQuesId(questionEntity.getQuesId());
		
		questionsDTO.setQuestion(decodeQuestion);
		questionsDTO.setMarks(questionEntity.getMarks());
		questionsDTO.setStatus(questionEntity.getStatus());
		
		questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());

		return questionsDTO;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.QuestionService#getAllQuestionInLanguageOrSubject(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public ArrayList<QuestionsDTO> getAllQuestionInLanguageOrSubject(Integer languageId, Integer subjectId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
