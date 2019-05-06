package lk.exame.test.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Null;

import org.apache.catalina.User;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.ClassEditor;
import org.springframework.stereotype.Service;

import lk.exame.test.dto.AnswersDTO;
import lk.exame.test.dto.ExameDTO;
import lk.exame.test.dto.ExameDetailsDTO;
import lk.exame.test.dto.LanguageDTO;
import lk.exame.test.dto.QuestionsDTO;
import lk.exame.test.dto.ReqDTO;
import lk.exame.test.dto.ResultDTO;

import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.ExameDetailsEntity;
import lk.exame.test.entity.ExameEntity;
import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.ResultEntity;

import lk.exame.test.repository.AnswerRepository;
import lk.exame.test.repository.ExameDetailRepository;
import lk.exame.test.repository.ExameRepository;
import lk.exame.test.repository.LanguageRepository;
import lk.exame.test.repository.QuestionRepository;
import lk.exame.test.repository.ResultRepository;

import lk.exame.test.service.ExameService;

@Service
public class ExameServiceImpl implements ExameService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private ExameDetailRepository exameDetailRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Autowired
	private ResultRepository resultRepository;

	@Autowired
	private LanguageRepository languageRepository;

	private QuestionEntity questionEntity = null;

	private ResultEntity resultEntity;

	@Override
	public Integer save(String userName, Integer languageId) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = formatter.format(date);

		SimpleDateFormat formatterDate = new SimpleDateFormat();
		Date dateDate = new SimpleDateFormat("dd/MM/yyyy").parse(formatterDate.format(date));

		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); Date date = new
		 * Date(); dateFormat.format(date);
		 */

		ExameEntity exameEntity = new ExameEntity();
		ExameDTO exameDTO = new ExameDTO();
		LanguageEntity languageEntity = languageRepository.getOne(languageId);

		exameEntity.setUserName(userName);
		exameEntity.setExameDate(dateDate);
		exameEntity.setRegDate(dateDate);
		exameEntity.setRegTime(time);
		exameEntity.setStartTime(time);
		exameEntity.setLanguageEntity(languageEntity);
		exameRepository.save(exameEntity);

		return exameEntity.getExameId();

		/*
		 * if (exame != null) { exameDTO.getExameDetailsEntities().forEach(exameDetail
		 * ->{ ExameDetailsEntity exameDetailsEntity = new ExameDetailsEntity();
		 * exameDetailsEntity.setExameEntity(exame);
		 * exameDetailRepository.save(exameDetailsEntity); }); } return true;
		 */
	}

	@Override
	public boolean delete(Integer exameId) throws Exception {
		exameRepository.deleteById(exameId);
		return true;
	}

	@Override
	public ExameDTO getExame(Integer exameId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ExameDTO> getAllExame() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Integer> getNumberStack() throws Exception {

		QuestionEntity questionEntity = new QuestionEntity();
		Integer getQues = getQuestionDto(questionEntity).getQuesId();

		List<Integer> getNumList = new ArrayList<>();

		getNumList.add(getQues);

		return getNumList;
	}

	/*
	 * @Override public QuestionAnswerDTO getQuestionAnsers(String langName) throws
	 * Exception {
	 * 
	 * 
	 * QuestionsDTO questionsDTO = new QuestionsDTO(); AnswersDTO answersDTO = new
	 * AnswersDTO(); UserAnswerQuestionDTO answerQuestionDTO = new
	 * UserAnswerQuestionDTO(); UserAnswersQuestionsEntity
	 * userAnswersQuestionsEntity = new UserAnswersQuestionsEntity();
	 * 
	 * 
	 * UserAnswer Add List<UserAnswersQuestionsEntity>list =
	 * userAnswerRepository.findAll(); List<Integer>userAnsDto = new ArrayList<>();
	 * 
	 * list.forEach(e->{ userAnsDto.add(getUserAnswer(e)); });
	 * 
	 * UserAnswer Add End Area
	 * 
	 * 
	 * System.out.println("Question Ids"+userAnsDto.toString());
	 * 
	 * 
	 * Integer total=Integer.valueOf(tol);
	 * 
	 * System.out.println("Total =/"+total.toString());
	 * 
	 * 
	 * if (userAnsDto.size() >= 60) {
	 * 
	 * String print = "Your Exame Succsess Fully Comleated ";
	 * 
	 * System.out.println(print);
	 * 
	 * 
	 * } System.out.println("Total =/"+total);
	 * 
	 * if (userAnsDto.isEmpty()) {
	 * 
	 * questionEntity = questionRepository.getPrimatyStage(langName);
	 * System.out.println("primary"); List<AnswerEntity>
	 * getAnswersEasy=answerRepository.findAllByQuestionEntity(questionEntity);
	 * List<AnswersDTO> getAllAnsweDto=new ArrayList<AnswersDTO>();
	 * 
	 * getAnswersEasy.forEach(answersPrimary->{
	 * getAllAnsweDto.add(getAnswerDto(answersPrimary)); }); QuestionAnswerDTO
	 * questionAnswerDTO=new QuestionAnswerDTO();
	 * questionAnswerDTO.setQuestionsDTO(getQuestionDto(questionEntity));
	 * questionAnswerDTO.setAnswersDTOs(getAllAnsweDto);
	 * 
	 * return questionAnswerDTO;
	 * 
	 * } else if(userAnsDto.size() >=1 && userAnsDto.size() <= 20 ) {
	 * System.out.println("Easy Stage"); questionEntity =
	 * questionRepository.getEasyQuestions(userAnsDto,langName);
	 * 
	 * List<AnswerEntity>
	 * getAnswersEzy=answerRepository.findAllByQuestionEntity(questionEntity);
	 * List<AnswersDTO> getAllAnsweDto=new ArrayList<AnswersDTO>();
	 * 
	 * getAnswersEzy.forEach(answersEzy->{
	 * getAllAnsweDto.add(getAnswerDto(answersEzy)); }); QuestionAnswerDTO
	 * questionAnswerDTO=new QuestionAnswerDTO();
	 * questionAnswerDTO.setQuestionsDTO(getQuestionDto(questionEntity));
	 * questionAnswerDTO.setAnswersDTOs(getAllAnsweDto);
	 * 
	 * return questionAnswerDTO; }
	 * 
	 * else if (userAnsDto.size() >=20 && userAnsDto.size() <=40) {
	 * System.out.println("Nomal Stage"); questionEntity =
	 * questionRepository.getNormalQuestions(userAnsDto,langName);
	 * 
	 * List<AnswerEntity>
	 * getAnswersNom=answerRepository.findAllByQuestionEntity(questionEntity);
	 * List<AnswersDTO> getAllAnsweDto=new ArrayList<AnswersDTO>();
	 * 
	 * getAnswersNom.forEach(answersNom->{
	 * getAllAnsweDto.add(getAnswerDto(answersNom)); }); QuestionAnswerDTO
	 * questionAnswerDTO=new QuestionAnswerDTO();
	 * questionAnswerDTO.setQuestionsDTO(getQuestionDto(questionEntity));
	 * questionAnswerDTO.setAnswersDTOs(getAllAnsweDto);
	 * 
	 * return questionAnswerDTO; }
	 * 
	 * else if (userAnsDto.size() >= 40 && userAnsDto.size() <= 60) {
	 * System.out.println("Hard Stage"); questionEntity =
	 * questionRepository.getHardQuestions(userAnsDto,langName);
	 * 
	 * List<AnswerEntity>
	 * getAnswersHard=answerRepository.findAllByQuestionEntity(questionEntity);
	 * List<AnswersDTO> getAllAnsweDto=new ArrayList<AnswersDTO>();
	 * System.out.println("gues id "+questionEntity.getQuesId());
	 * 
	 * getAnswersHard.forEach(answersHard->{
	 * getAllAnsweDto.add(getAnswerDto(answersHard)); });
	 * 
	 * QuestionAnswerDTO questionAnswerDTO=new QuestionAnswerDTO();
	 * questionAnswerDTO.setQuestionsDTO(getQuestionDto(questionEntity));
	 * questionAnswerDTO.setAnswersDTOs(getAllAnsweDto);
	 * 
	 * return questionAnswerDTO;
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * }
	 */
	@Override
	public List<ExameDetailsDTO> updateQuestion() throws Exception {

		return null;
	}

	@Override
	public boolean submitQuestion(List<QuestionsDTO> questionsDTOs, Integer exameId) throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(dateFormat.format(date));

		DateFormat dateTimeFormat = new SimpleDateFormat("HH:mm:ss");
		Date dateTime = new Date();
		String endTime = dateTimeFormat.format(date);

		ExameEntity exameEntity = exameRepository.getOne(exameId);
		
		List<ResultEntity>resultEntities = resultRepository.findAll();
		
		
		/*
		 * Integer ResultIdInExameEntity = exameEntity.getResultEntity().getResultId();
		 * 
		 * resultEntity = resultRepository.getByResultId(ResultIdInExameEntity);
		 */

		String userName = exameEntity.getUserName();

		System.out.println("User Name =/" + userName);

		questionsDTOs.forEach(e -> {

			if (e.getCorrect().contentEquals("true")) { //
				
				
				System.out.println("getlOOP-1");
				
				if (resultEntities != null) {

					System.out.println("Condition Succsess -1  !");
					ResultEntity result = new ResultEntity();

					result.setUserName(userName);

					result.setStartTime(exameEntity.getRegTime());
					result.setExameDate(date1);
					result.setEndTime(dateFormat.format(dateTime));
					result.setTotal(e.getMarks());
					result.setCorrectAnswers(1);
					resultEntity = resultRepository.save(result);

					exameEntity.setResultEntity(result);
					exameRepository.save(exameEntity);
					
				} else {
					
					Integer resId = exameEntity.getResultEntity().getResultId();
					
					resultEntity = resultRepository.getOne(resId);
					
					System.out.println("working res");

					System.out.println(resultEntities.toArray().toString());
					// resultEntity.setExameDate(date1);


					Integer total = resultEntity.getTotal();
					Integer fulltotal = total + e.getMarks();
					resultEntity.setTotal(fulltotal);

					Integer correct = resultEntity.getCorrectAnswers();
					correct++;

					resultEntity.setCorrectAnswers(correct);

					resultRepository.save(resultEntity);
				}

			} else if (e.getCorrect().contentEquals("false")) {

				if (resultEntities != null) {
					
					System.out.println("Work w");
					ResultEntity result = new ResultEntity();

					result.setUserName(userName);
					result.setStartTime(exameEntity.getStartTime());
					result.setExameDate(date1);
					result.setWrongAnswers(1);

					resultRepository.save(result);
					
					exameEntity.setResultEntity(result);
					exameRepository.save(exameEntity);

				} else {

					System.out.println("wrong Else ok");
					resultEntity.setEndTime(dateFormat.format(dateTime));

					Integer wrong = resultEntity.getWrongAnswers();
					wrong++;
					resultEntity.setWrongAnswers(wrong);

					resultRepository.save(resultEntity);
				}

			}
		});

		/*
		 * ResultDTO resultDTO = new ResultDTO(); ResultEntity resultId =
		 * resultRepository.getOne(resultDTO.getResultId());
		 */

		if (exameEntity != null) {

			exameEntity.setExameDate(date1);
			exameEntity.setEndTime(endTime);
			

			exameRepository.save(exameEntity);
		}

		/*
		 * ExameDTO exameDTO = new ExameDTO(); ExameEntity exameEntity =
		 * exameRepository.getOne(exameId);
		 * 
		 * ExameDetailsEntity exameDetailsEntity = new ExameDetailsEntity();
		 * ExameDetailsDTO exameDetailsDTO = new ExameDetailsDTO();
		 * 
		 * ResultEntity resultEntity = new ResultEntity();
		 * 
		 * UserAnswersQuestionsEntity userAnswersQuestionsEntity = new
		 * UserAnswersQuestionsEntity(); UserAnswerQuestionDTO userAnswerQuestionDTO =
		 * new UserAnswerQuestionDTO();
		 * 
		 * UserGetQuestionsEntity userGetQuestionsEntity = new UserGetQuestionsEntity();
		 * UserGetQuestionsDTO userGetQuestionsDTO = new UserGetQuestionsDTO();
		 * 
		 * List<UserAnswersQuestionsEntity>list = userAnswerRepository.findAll();
		 * List<Integer>userAnsDto = new ArrayList<>();
		 * 
		 * Integer arraySize = userAnsDto.size();
		 * 
		 * System.out.println("get Quesions =/"+arraySize.toString());
		 * 
		 * 
		 * 
		 * 
		 * resultEntity.setTotalQuestions(arraySize);
		 * resultEntity.setCorrectAnswers(resultDTO.getCorrectAnswers());
		 * resultEntity.setWrongAnswers(resultDTO.getWrongAnswers());
		 * resultEntity.setTotal(resultDTO.getTotal());
		 * 
		 * resultEntity.setStartTime(resultDTO.getStartTime());
		 * resultEntity.setExameDate(date1);
		 * resultEntity.setEndTime(dateFormat.format(dateTime));
		 * 
		 * resultRepository.save(resultEntity);
		 * 
		 * if (exameEntity != null) {
		 * 
		 * System.out.println("exame condition work . . . !");
		 * 
		 * exameEntity.setExameDate(date1);
		 * exameEntity.setEndTime(dateFormat.format(dateTime));
		 * exameEntity.setStartTime(resultDTO.getStartTime());
		 * exameEntity.setMarks(resultDTO.getTotal());
		 * 
		 * exameRepository.save(exameEntity); }
		 * 
		 * if (userGetQuestionsEntity.getUserGetQuesId() == null) {
		 * 
		 * userGetQuestionsEntity.setExameId(exameId);
		 * userGetQuestionsEntity.setLanguAge(langName);
		 * userGetQuestionsEntity.setUserName(userName);
		 * 
		 * userGetQuestionsRepository.save(userGetQuestionsEntity);
		 * 
		 * }else if (userGetQuestionsEntity.getUserGetQuesId() !=null) {
		 * 
		 * userGetQuestionsEntity.setExameId(exameId);
		 * userGetQuestionsEntity.setLanguAge(langName);
		 * userGetQuestionsEntity.setUserName(userName);
		 * 
		 * userGetQuestionsRepository.save(userGetQuestionsEntity); }
		 */

		return true;
	}

	/*
	 * @Override public QuestionAnswerDTO backStep(Integer quesId) throws Exception
	 * {
	 * 
	 * UserAnswersQuestionsEntity userAnswersQuestionsEntity = null;
	 * UserAnswerQuestionDTO userAnswerQuestionDTO = null;
	 * 
	 * userAnswersQuestionsEntity = userAnswerRepository.getBackQuestions(quesId);
	 * 
	 * System.out.println("UserAnswerQues =/" +
	 * userAnswersQuestionsEntity.toString());
	 * 
	 * System.out.println("quesid =/" + quesId.toString());
	 * 
	 * String val = "backQ";
	 * 
	 * userAnswersQuestionsEntity.setBackQues(val);
	 * 
	 * userAnswerRepository.save(userAnswersQuestionsEntity);
	 * 
	 * questionEntity = questionRepository.findById(quesId).get();
	 * 
	 * List<AnswerEntity> getAnswersEasy =
	 * answerRepository.findAllByQuestionEntity(questionEntity); List<AnswersDTO>
	 * getAllAnsweDto = new ArrayList<AnswersDTO>();
	 * 
	 * getAnswersEasy.forEach(answers -> {
	 * getAllAnsweDto.add(getAnswerDto(answers)); });
	 * 
	 * QuestionAnswerDTO questionAnswerDTO = new QuestionAnswerDTO();
	 * questionAnswerDTO.setQuestionsDTO(getQuestionDto(questionEntity));
	 * questionAnswerDTO.setAnswersDTOs(getAllAnsweDto);
	 * 
	 * return questionAnswerDTO;
	 * 
	 * 
	 * List<AnswerEntity>
	 * getAnswersEasy=answerRepository.findAllByQuestionEntity(questionEntity);
	 * List<AnswersDTO> getAllAnsweDto=new ArrayList<AnswersDTO>();
	 * 
	 * getAnswersEasy.forEach(answersPrimary->{
	 * getAllAnsweDto.add(getAnswerDto(answersPrimary)); }); QuestionAnswerDTO
	 * questionAnswerDTO=new QuestionAnswerDTO();
	 * questionAnswerDTO.setQuestionsDTO(getQuestionDto(questionEntity));
	 * questionAnswerDTO.setAnswersDTOs(getAllAnsweDto);
	 * 
	 * 
	 * }
	 */

	private QuestionsDTO getQuestionDto(QuestionEntity questionEntity) {

		QuestionsDTO questionsDTO = new QuestionsDTO();

		questionsDTO.setQuesId(questionEntity.getQuesId());

		System.out.println("This === /" + questionEntity.getQuesId().toString());

		Integer ques = questionEntity.getQuesId();

		System.out.println("ques =/" + ques.toString());

		questionsDTO.setQuestion(questionEntity.getQuestion());
		questionsDTO.setMarks(questionEntity.getMarks());
		questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());

		System.out.println("questions Dto =/" + questionsDTO.toString());

		return questionsDTO;

	}

	

	/*
	 * @Override public ArrayList<QuestionAnswerDTO> getAllQuestionAnswer() throws
	 * Exception {
	 * 
	 * QuestionsDTO questionsDTO = new QuestionsDTO(); QuestionEntity questionEntity
	 * = new QuestionEntity();
	 * 
	 * AnswerEntity answerEntity = new AnswerEntity(); AnswersDTO answersDTO = new
	 * AnswersDTO();
	 * 
	 * QuestionAnswerDTO questionAnswerDTO = new QuestionAnswerDTO();
	 * 
	 * questionsDTO.setQuesId(questionEntity.getQuesId());
	 * questionsDTO.setQuestionQ(questionEntity.getQuestionQ());
	 * questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
	 * questionsDTO.setLangName(questionEntity.getLangName());
	 * questionsDTO.setMarks(questionEntity.getMarks());
	 * 
	 * answersDTO.setAnswerId(answersDTO.getAnswerId());
	 * answersDTO.setAnsewer(answerEntity.getAnsewer());
	 * answersDTO.setTagName(answersDTO.getTagName());
	 * answersDTO.setTrueFalse(answerEntity.getTrueFalse());
	 * 
	 * questionAnswerDTO.setQuestionsDTO(questionsDTO);
	 * 
	 * return null; }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.exame.test.service.ExameService#getExameId()
	 */
	@Override
	public ArrayList<ExameDTO> getExameId(String userName) throws Exception {

		List<ExameEntity> exameEntities = exameRepository.findByUserNameList(userName);
		ArrayList<ExameDTO> exameDTOs = new ArrayList<>();
		
		exameEntities.forEach(e -> {
			exameDTOs.add(getExameAll(e));
		});
		return exameDTOs;
	}

	private ExameDTO getExameAll(ExameEntity exameEntity) {

		ExameDTO exameDTO = new ExameDTO();

		exameDTO.setExameId(exameEntity.getExameId());
		exameDTO.setExameDate(exameEntity.getExameDate());
		exameDTO.setUserName(exameEntity.getUserName());
		exameDTO.setUserName(exameEntity.getUserName());
		exameDTO.setRegDate(exameEntity.getRegDate());
		exameDTO.setRegTime(exameEntity.getRegTime());
		
		return exameDTO;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.exame.test.service.ExameService#getExame()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.exame.test.service.ExameService#getQuestion(java.lang.String)
	 */
	@Override
	public QuestionsDTO getQuestion(ReqDTO reqDTO) throws Exception {

		  QuestionsDTO questionsDTO = new QuestionsDTO();
		  ExameEntity exameEntity = exameRepository.getOne(reqDTO.getExameId());
		  
		 Integer languageId = exameEntity.getLanguageEntity().getLangId();
		  
		 System.out.println("Language == /"+languageId);
		 ArrayList<Integer> quaryNum = new ArrayList<>();

		 quaryNum.addAll(reqDTO.getQuestionIds());
		
		System.out.println("Question Ids =/" + quaryNum);
		

		System.out.println("Question Ids" + reqDTO.getQuestionIds().toString());

		  if (reqDTO.getQuestionIds().size() >= 60) {
		  
		  String print = "Your Exame Succsess Fully Comleated ";
		  
		  System.out.println(print);
		  
		  } 
		  
		  if (reqDTO.getQuestionIds().isEmpty()) {
		  
		  questionEntity = questionRepository.getPrimatyStage(languageId);
		  System.out.println("primary");
		  List<AnswerEntity> getAnswersEasy =  answerRepository.findAllByQuestionEntity(questionEntity);
		  List<AnswersDTO>
		  getAllAnsweDto = new ArrayList<AnswersDTO>();
		  
		  getAnswersEasy.forEach(answersPrimary -> {
			  System.out.println("Loop - 1");
		  getAllAnsweDto.add(getAnswerDto(answersPrimary));
		  });
		  
		  questionsDTO.setQuesId(questionEntity.getQuesId());
		  questionsDTO.setQuestion(questionEntity.getQuestion());
		  questionsDTO.setMarks(questionEntity.getMarks());
		  
		  questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
		  questionsDTO.setStatus(questionEntity.getStatus());
		  
		  questionsDTO.setAnswerDtos(getAllAnsweDto);
		  
		  return questionsDTO;
		  
		  } else if (reqDTO.getQuestionIds().size() >= 1 && reqDTO.getQuestionIds().size() <= 20) {
		  
		  System.out.println("Easy Stage"); questionEntity =
		  questionRepository.getEasyQuestions(quaryNum, languageId);
		  
		  List<AnswerEntity> getAnswersEzy = answerRepository.findAllByQuestionEntity(questionEntity);
		  List<AnswersDTO> getAllAnsweDto = new ArrayList<AnswersDTO>();
		  
		  getAnswersEzy.forEach(answersEzy -> {
		  getAllAnsweDto.add(getAnswerDto(answersEzy));
		  System.out.println("Loop - 2");
		  
		  });
		  
		  questionsDTO.setQuesId(questionEntity.getQuesId());
		  questionsDTO.setQuestion(questionEntity.getQuestion());
		  questionsDTO.setMarks(questionEntity.getMarks());
		  
		  questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
		  questionsDTO.setStatus(questionEntity.getStatus());
		  
		  
		  
		  questionsDTO.setAnswerDtos(getAllAnsweDto);
		  
		  return questionsDTO; 
		  }
		  
		  else if (reqDTO.getQuestionIds().size() >= 20 && reqDTO.getQuestionIds().size() <= 40) {
		  
		  System.out.println("Nomal Stage");
		  questionEntity = questionRepository.getNormalQuestions(quaryNum, languageId);
		  
		  List<AnswerEntity> getAnswersNom =answerRepository.findAllByQuestionEntity(questionEntity);
		  List<AnswersDTO> getAllAnsweDto = new ArrayList<AnswersDTO>();
		  
		  getAnswersNom.forEach(answersNom -> {
		  getAllAnsweDto.add(getAnswerDto(answersNom)); });
		  
		  questionsDTO.setQuesId(questionEntity.getQuesId());
		  questionsDTO.setQuestion(questionEntity.getQuestion());
		  questionsDTO.setMarks(questionEntity.getMarks());
		  
		  questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
		  questionsDTO.setStatus(questionEntity.getStatus());
		  
		  
		  questionsDTO.setAnswerDtos(getAllAnsweDto);
		  
		  return questionsDTO;
		  }
		  
		  else if (reqDTO.getQuestionIds().size() >= 40 && reqDTO.getQuestionIds().size() <= 59) {
		  
		  System.out.println("Hard Stage"); questionEntity =
		  questionRepository.getHardQuestions(quaryNum, languageId);
		  
		  List<AnswerEntity> getAnswersHard =
		  answerRepository.findAllByQuestionEntity(questionEntity); List<AnswersDTO>
		  getAllAnsweDto = new ArrayList<AnswersDTO>(); System.out.println("gues id " +
		  questionEntity.getQuesId());
		  
		  getAnswersHard.forEach(answersHard -> {
		  getAllAnsweDto.add(getAnswerDto(answersHard)); });
		  
		  questionsDTO.setQuesId(questionEntity.getQuesId());
		  questionsDTO.setQuestion(questionEntity.getQuestion());
		  questionsDTO.setMarks(questionEntity.getMarks());
		  
		  questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
		  questionsDTO.setStatus(questionEntity.getStatus());
		  
		  
		  questionsDTO.setAnswerDtos(getAllAnsweDto);
		  
		  return questionsDTO;
		  
		  }
		 
		return null;
	}

	private LanguageDTO getLanguageDto(LanguageEntity languageEntity) {

		LanguageDTO languageDTO = new LanguageDTO();

		languageDTO.setLangId(languageEntity.getLangId());
		languageDTO.setLangName(languageEntity.getLangName());

		return languageDTO;
	}
	
	private AnswersDTO getAnswerDto(AnswerEntity answerEntity) {

		AnswersDTO answersDTO = new AnswersDTO();
		answersDTO.setAnswerId(answerEntity.getAnswerId());
		answersDTO.setAnsewer(answerEntity.getAnsewer());
		answersDTO.setCorrect(answerEntity.getCorrect());
		answersDTO.setTagName(answerEntity.getTagName());
		answersDTO.setQuestionId(answerEntity.getQuestionEntity().getQuesId());

		return answersDTO;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.ExameService#getExameResult(java.lang.Integer)
	 */
	@Override
	public ResultDTO getExameResult(Integer exameId) throws Exception {
		
		ExameEntity exameEntity = exameRepository.getOne(exameId);
		
		Integer resultId = exameEntity.getResultEntity().getResultId();
		
		ResultEntity resultEntity = resultRepository.getOne(resultId);
		ResultDTO resultDTO = new ResultDTO();
		
		resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		resultDTO.setEndTime(resultEntity.getEndTime());
		resultDTO.setExameDate(resultEntity.getExameDate());
		resultDTO.setResultId(resultEntity.getResultId());
		resultDTO.setStartTime(resultEntity.getStartTime());
		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		
		return resultDTO;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.ExameService#getResultByExameUserName(java.lang.String)
	 */
	@Override
	public ArrayList<ResultDTO> getResultByExameUserName(String userName) throws Exception {
		
		List<ExameEntity>exameEntities = exameRepository.findByUserNameList(userName);
		
		ArrayList<Integer>exameDTOs = new ArrayList<>();
		
		exameEntities.forEach(e->{
			exameDTOs.add(e.getResultEntity().getResultId());
		});
		
		List<ResultEntity>resultEntities = resultRepository.findAllById(exameDTOs);
		
		ArrayList<ResultDTO>resultDTOs = new ArrayList<ResultDTO>();
		
		resultEntities.forEach(e->{
			resultDTOs.add(getResult(e));
		});
		return resultDTOs;
	}
	
	private ResultDTO getResult(ResultEntity resultEntity) {
		
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setResultId(resultEntity.getResultId());
		resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		resultDTO.setEndTime(resultEntity.getEndTime());
		resultDTO.setExameDate(resultEntity.getExameDate());
		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		
		return resultDTO;
	}
}
