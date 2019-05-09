package lk.exame.test.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lk.exame.test.AppConstant;
import lk.exame.test.dao.AnswerDAO;
import lk.exame.test.dao.ExameDAO;
import lk.exame.test.dao.ExameDetailDAO;
import lk.exame.test.dao.LanguageDAO;
import lk.exame.test.dao.QuestionDAO;
import lk.exame.test.dao.ResultDAO;
import lk.exame.test.dao.custom.QuestionDaoCustom;
import lk.exame.test.dto.AnswersDTO;
import lk.exame.test.dto.ExameDTO;
import lk.exame.test.dto.ExameDetailsDTO;
import lk.exame.test.dto.LanguageDTO;
import lk.exame.test.dto.QuestionsDTO;
import lk.exame.test.dto.ReqDTO;
import lk.exame.test.dto.ResultDTO;
import lk.exame.test.dto.SubmitQuestionDTO;
import lk.exame.test.entity.AnswerEntity;

import lk.exame.test.entity.ExameEntity;
import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.ResultEntity;
import lk.exame.test.service.ExameService;

@Service
public class ExameServiceImpl implements ExameService {

	@Autowired
	private QuestionDAO questionDao;

	@Autowired
	private ExameDAO exameDao;

	@Autowired
	private ExameDetailDAO exameDetailDao;

	@Autowired
	private AnswerDAO answerDao;

	@Autowired
	private ResultDAO resultDao;

	@Autowired
	private LanguageDAO languageDao;

	@Autowired
	private QuestionDaoCustom questionCustomDao;
	
	private Integer id ;
	
	/*
	 * private QuestionEntity questionEntity = null;
	 * 
	 * private ResultEntity resultEntity;
	 */

	@Override
	public Integer save(String userName, Integer languageId) throws Exception {
		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss"); Date date =
		 * new Date(); String time = formatter.format(date);
		 * 
		 * SimpleDateFormat formatterDate = new SimpleDateFormat(); Date dateDate = new
		 * SimpleDateFormat("dd/MM/yyyy").parse(formatterDate.format(date));
		 * 
		 * 
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); Date date = new
		 * Date(); dateFormat.format(date);
		 * 
		 * 
		 * ExameEntity exameEntity = new ExameEntity(); ExameDTO exameDTO = new
		 * ExameDTO(); LanguageEntity languageEntity =
		 * languageRepository.getOne(languageId);
		 * 
		 * exameEntity.setUserName(userName); exameEntity.setExameDate(dateDate);
		 * exameEntity.setRegDate(dateDate); exameEntity.setRegTime(time);
		 * exameEntity.setStartTime(time);
		 * exameEntity.setLanguageEntity(languageEntity);
		 * exameRepository.save(exameEntity);
		 */

		return null;

		/*
		 * if (exame != null) { exameDTO.getExameDetailsEntities().forEach(exameDetail
		 * ->{ ExameDetailsEntity exameDetailsEntity = new ExameDetailsEntity();
		 * exameDetailsEntity.setExameEntity(exame);
		 * exameDetailRepository.save(exameDetailsEntity); }); } return true;
		 */
	}

	@Override
	public boolean delete(Integer exameId) throws Exception {
		ExameEntity exameEntity = exameDao.findById(exameId).get();
		exameEntity.setStatus(AppConstant.DEACTIVE);
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
	public ResultDTO submitQuestion(List<SubmitQuestionDTO> submitQuestionDTOs, String userName, Integer languageId)throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = formatter.format(date);

		SimpleDateFormat formatterDate = new SimpleDateFormat();
		Date dateDate = new SimpleDateFormat("dd/MM/yyyy").parse(formatterDate.format(date));

		ExameEntity exameEntity = new ExameEntity();
		LanguageEntity languageEntity = languageDao.findByLangId(languageId);

		  exameEntity.setUserName(userName);
		  exameEntity.setExameDate(dateDate);
		  exameEntity.setRegDate(dateDate);
		  exameEntity.setRegTime(time);
		  exameEntity.setStartTime(time);
		  exameEntity.setLanguageEntity(languageEntity);
		  exameEntity.setStatus(AppConstant.ACTIVE);
		  
		  ResultEntity resultEntity = new ResultEntity();
		  resultEntity.setExameDate(new Date());
		  resultEntity.setUserName(userName);
		  
		  submitQuestionDTOs.forEach(subQues -> {
		  
		System.out.println("Called submitQuestion . . . . ");
		  resultEntity.setTotalQuestions(resultEntity.getTotalQuestions() + 1);
		  
		  System.out.println("Total question = =/"+resultEntity.toString());
		  
		  QuestionEntity questionEntity = questionDao.findById(subQues.getQuestionId()).get();
		  
		  boolean isCorrect = false;
		  boolean isWrong = false;
		  
		  for (AnswerEntity answerEntity : questionEntity.getAnswerEntities()) {
			  
		  if(answerEntity.getAnswerId() == subQues.getUserAnswerId()) {
			  
			  if (answerEntity.getCorrect().equals(1)) {
				  isCorrect = true; 
			  }else if (answerEntity.getCorrect().equals(0)) {
				
				isWrong = true;
			  }
			  
			  } 
		  }
		  
		  if(isCorrect) {
			  System.out.println("Loop isCorrect ok . .");
		  resultEntity.setCorrectAnswers(resultEntity.getCorrectAnswers() + 1);
		  
		  if (resultEntity.getTotal() == null) {
			
			  resultEntity.setTotal(questionEntity.getMarks());
			  
		  }else {
			
			resultEntity.setTotal(resultEntity.getTotal() + questionEntity.getMarks());
			
		  }
		  
		  }else if (isWrong) {
			resultEntity.setWrongAnswers(resultEntity.getWrongAnswers() + 1);
		}
		  });
		  
		  exameEntity.setResultEntity(resultDao.save(resultEntity));
		  
		  exameDao.save(exameEntity);
		 

		/*
		 * ResultEntity resultEntity = new ResultEntity(); Integer exameIdget =
		 * exameEntity.getExameId(); ExameEntity exame =
		 * exameDao.findById(exameIdget).get();
		 * 
		 * System.out.println("exame Id get =/" + exameIdget);
		 * 
		 * 
		 * 
		 * submitQuestionDTOs.forEach(e -> {
		 * 
		 * System.out.println("FOR Each Ok . . ."); QuestionEntity questionEntity =
		 * questionDao.findById(e.getQuestionId()).get();
		 * 
		 * 
		 * 
		 * //AnswerEntity answerEntity = answerRepository.getOne(e.getUserAnswerId());
		 * 
		 * if (answerEntity.getCorrect().equals(1)) {
		 * 
		 * if (exameEntity.getResultEntity() == null) {
		 * 
		 * System.out.println("Wrong else Correct (null) . . . "); Integer thisTot =
		 * questionEntity.getMarks();
		 * 
		 * ResultEntity result = new ResultEntity();
		 * 
		 * result.setCorrectAnswers(1); result.setUserName(userName);
		 * result.setTotal(thisTot); result.setTotalQuestions(60);
		 * 
		 * resultDao.save(result);
		 * 
		 * exameEntity.setResultEntity(result); exameDao.save(exameEntity); } else {
		 * 
		 * System.out.println("Wrong else Working (not null) . . . ");
		 * 
		 * resultEntity =
		 * resultDao.findById(exameEntity.getResultEntity().getResultId()).get();
		 * 
		 * System.out.println("Id Passing . . ."); Integer total =
		 * resultEntity.getTotal(); total++; resultEntity.setTotal(total);
		 * 
		 * resultDao.save(resultEntity); }
		 * 
		 * } else if (answerEntity.getCorrect().equals(0)) {
		 * 
		 * System.out.println("Wrong else Working (null) . . . ");
		 * 
		 * if (exameEntity.getResultEntity() == null) {
		 * 
		 * ResultEntity result = new ResultEntity(); result.setWrongAnswers(1);
		 * 
		 * resultDao.save(result);
		 * 
		 * 
		 * exame.setResultEntity(result); exameDao.save(exame);
		 * 
		 * }else { System.out.println("Wrong else Working (not null) . . . ");
		 * resultEntity = resultDao.findById(resultEntity.getResultId()).get();
		 * 
		 * 
		 * Integer wrong = resultEntity.getWrongAnswers(); wrong++;
		 * resultEntity.setWrongAnswers(wrong); resultDao.save(resultEntity); }
		 * 
		 * }
		 * 
		 * });
		 */
		  
		 Integer resId = resultEntity.getResultId();
		 
		 ResultEntity getCurrentResult = resultDao.findById(resId).get();
		 
		 ResultDTO resultDTO = new ResultDTO();
		 
		 resultDTO.setResultId(resultEntity.getResultId());
		 resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		 resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		 resultDTO.setExameDate(resultEntity.getExameDate());
		 resultDTO.setTotal(resultEntity.getTotal());
		 resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		 resultDTO.setUserName(resultEntity.getUserName());

		return resultDTO;
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

		String status = AppConstant.ACTIVE;
		List<ExameEntity> exameEntities = exameDao.findByUserNameAndStatus(userName,status);
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
	public QuestionsDTO getQuestion(ReqDTO reqDTO, Integer languageId) throws Exception {

		QuestionEntity questionEntity = new QuestionEntity();
		  
		ResultEntity resultEntity = new ResultEntity();
		
		QuestionsDTO questionsDTO = new QuestionsDTO();

		System.out.println("Language == /" + languageId);
		ArrayList<Integer> quesNum = new ArrayList<>();

		quesNum.addAll(reqDTO.getQuestionIds());

		System.out.println("Question Ids =/" + quesNum);

		System.out.println("Question Ids" + reqDTO.getQuestionIds().toString());

		if (reqDTO.getQuestionIds().size() >= 60) {

			String print = "Your Exame Succsess Fully Comleated ";

			System.out.println(print);

		}

		if (reqDTO.getQuestionIds().isEmpty()) {

			
			 LanguageEntity language = languageDao.findById(languageId).get();
			/*
			 * questionEntity =
			 * questionRepository.findOneByQuestionLevalAndStatusAndLanguageEntitiey(
			 * quesLeval, status, language);
			 */
			 
			
			  String questionLeval ="Easy";
			  String status = AppConstant.ACTIVE;
			  
			  List<QuestionEntity> getQuestion =questionCustomDao.getPrimaryStage(questionLeval,status,languageId);
			  
			  List<QuestionsDTO>getQuestionDto = new ArrayList<QuestionsDTO>();
			  
			  getQuestion.forEach(each->{
				  id = each.getQuesId();
			  });
			
			  
			System.out.println("id . . . /"+id);
			  
			questionEntity = questionDao.findById(id).get();
			
			  
			  
			  
			/* questionEntity = questionDao.getPrimatyStage(languageId); */
			
			  System.out.println("primary");
			  List<AnswerEntity> getAnswersEasy = answerDao.findAllByQuestionEntity(questionEntity); 
			  List<AnswersDTO>  getAllAnsweDto = new ArrayList<AnswersDTO>();
			  
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
			 

		} 
			  else if (reqDTO.getQuestionIds().size() >= 1 && reqDTO.getQuestionIds().size() <= 20) {
			  
			  System.out.println("Easy Stage");
			  
			  String questionLeval ="Easy";
			  String status = AppConstant.ACTIVE;
			  
			/* questionEntity = questionDao.getEasyQuestions(quaryNum, languageId); */
			  
			 List<QuestionEntity> questionSecon = questionCustomDao.getSeconderyStage(questionLeval, status, languageId, quesNum);
			 
			 questionSecon.forEach(each->{
				 id = each.getQuesId();
			 });
			 
			 questionEntity = questionDao.findById(id).get();
			 
			
			  List<AnswerEntity> getAnswersEzy =
			  answerDao.findAllByQuestionEntity(questionEntity); 
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
			  
			  }else if (reqDTO.getQuestionIds().size() >= 20 && reqDTO.getQuestionIds().size() <= 40) {
			  
				String questionLeval ="Nomal";
				String status = AppConstant.ACTIVE;
				  
			  System.out.println("Nomal Stage");
			  
			  List<QuestionEntity>getNomalQuestion = questionCustomDao.getSeconderyStage(questionLeval, status, languageId, quesNum);
			 
			  getNomalQuestion.forEach(each->{
				  id = each.getQuesId();
			  });
			  
			  questionEntity = questionDao.findById(id).get(); 
					  
			  List<AnswerEntity> getAnswersNom = answerDao.findAllByQuestionEntity(questionEntity);
			  List<AnswersDTO>getAllAnsweDto = new ArrayList<AnswersDTO>();
			  
			  getAnswersNom.forEach(answersNom -> {
			  getAllAnsweDto.add(getAnswerDto(answersNom)); });
			  
			  questionsDTO.setQuesId(questionEntity.getQuesId());
			  questionsDTO.setQuestion(questionEntity.getQuestion());
			  questionsDTO.setMarks(questionEntity.getMarks());
			  
			  questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
			  questionsDTO.setStatus(questionEntity.getStatus());
			  
			  questionsDTO.setAnswerDtos(getAllAnsweDto);
			  
			  return questionsDTO;
			  
			  }else if (reqDTO.getQuestionIds().size() >= 40 && reqDTO.getQuestionIds().size() <= 59) {
			  
				String questionLeval ="Hard";
				String status = AppConstant.ACTIVE;
					
			  System.out.println("Hard Stage");
			  List<QuestionEntity>getHardQuestion = questionCustomDao.getSeconderyStage(questionLeval, status, languageId, quesNum);
			  
			  getHardQuestion.forEach(each->{
				  id = each.getQuesId();
			  });
			  questionEntity = questionDao.findById(id).get();
			  
			  List<AnswerEntity> getAnswersHard = answerDao.findAllByQuestionEntity(questionEntity); List<AnswersDTO>
			  getAllAnsweDto = new ArrayList<AnswersDTO>();
			  System.out.println("gues id " +questionEntity.getQuesId());
			  
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see lk.exame.test.service.ExameService#getExameResult(java.lang.Integer)
	 */
	@Override
	public ResultDTO getExameResult(Integer exameId) throws Exception {

		ExameEntity exameEntity = exameDao.findFirst1ByExameId(exameId);

		Integer resultId = exameEntity.getResultEntity().getResultId();

		ResultEntity resultEntity = resultDao.findById(resultId).get();
		ResultDTO resultDTO = new ResultDTO();

		resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		
		resultDTO.setExameDate(resultEntity.getExameDate());
		resultDTO.setResultId(resultEntity.getResultId());
		
		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());

		return resultDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.exame.test.service.ExameService#getResultByExameUserName(java.lang.String)
	 */
	@Override
	public ArrayList<ResultDTO> getResultByExameUserName(String userName) throws Exception {

		String status = AppConstant.ACTIVE;
		List<ExameEntity> exameEntities = exameDao.findByUserNameAndStatus(userName,status);

		ArrayList<Integer> exameDTOs = new ArrayList<>();

		exameEntities.forEach(e -> {
			exameDTOs.add(e.getResultEntity().getResultId());
		});

		List<ResultEntity> resultEntities = (List<ResultEntity>) resultDao.findAllById(exameDTOs);

		ArrayList<ResultDTO> resultDTOs = new ArrayList<ResultDTO>();

		resultEntities.forEach(e -> {
			resultDTOs.add(getResult(e));
		});
		return resultDTOs;
	}

	private ResultDTO getResult(ResultEntity resultEntity) {

		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setResultId(resultEntity.getResultId());
		resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		
		resultDTO.setExameDate(resultEntity.getExameDate());
		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());

		return resultDTO;
	}
	
}
