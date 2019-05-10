package lk.exame.test.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lk.exame.test.AppConstant;
import lk.exame.test.dao.AnswerDAO;
import lk.exame.test.dao.ExameDAO;
import lk.exame.test.dao.ExameDetailDAO;
import lk.exame.test.dao.LanguageDAO;
import lk.exame.test.dao.QuestionDAO;
import lk.exame.test.dao.ResultDAO;
import lk.exame.test.dto.AnswersDTO;
import lk.exame.test.dto.ExameDTO;
import lk.exame.test.dto.ExameDetailsDTO;
import lk.exame.test.dto.QuestionsDTO;
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
	private AnswerDAO answerDao;

	@Autowired
	private ResultDAO resultDao;

	@Autowired
	private LanguageDAO languageDao;

	private Integer id;
	private Random random = new Random();
	
	private QuestionEntity questionEnt;
	/*
	 * private QuestionEntity questionEntity = null;
	 * 
	 * private ResultEntity resultEntity;
	 */

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

	@Override
	public List<ExameDetailsDTO> updateQuestion() throws Exception {

		return null;
	}

	@Override
	public ResultDTO submitQuestion(List<SubmitQuestionDTO> submitQuestionDTOs, String userName, Integer languageId)
			throws Exception {

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

			System.out.println("Total question = =/" + resultEntity.toString());

			QuestionEntity questionEntity = questionDao.findById(subQues.getQuestionId()).get();

			boolean isCorrect = false;
			boolean isWrong = false;

			for (AnswerEntity answerEntity : questionEntity.getAnswerEntities()) {

				if (answerEntity.getAnswerId() == subQues.getUserAnswerId()) {

					if (answerEntity.getCorrect().equals(1)) {
						isCorrect = true;
					} else if (answerEntity.getCorrect().equals(0)) {

						isWrong = true;
					}

				}
			}

			if (isCorrect) {
				System.out.println("Loop isCorrect ok . .");
				resultEntity.setCorrectAnswers(resultEntity.getCorrectAnswers() + 1);

				if (resultEntity.getTotal() == null) {

					resultEntity.setTotal(questionEntity.getMarks());

				} else {

					resultEntity.setTotal(resultEntity.getTotal() + questionEntity.getMarks());

				}

			} else if (isWrong) {
				resultEntity.setWrongAnswers(resultEntity.getWrongAnswers() + 1);
			}
		});

		
		exameEntity.setResultEntity(resultDao.save(resultEntity));
		
		
		exameDao.save(exameEntity);
		
		
		String language = languageEntity.getLangName();

		ResultDTO resultDTO = new ResultDTO();

		resultDTO.setResultId(resultEntity.getResultId());
		resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		resultDTO.setExameDate(resultEntity.getExameDate());
		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setUserName(resultEntity.getUserName());
		resultDTO.setLanguage(language);

		return resultDTO;
	}

	@Override
	public ArrayList<ExameDTO> getExameId(String userName) throws Exception {

		String status = AppConstant.ACTIVE;
		List<ExameEntity> exameEntities = exameDao.findByUserNameAndStatus(userName, status);
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

	@Override
	public QuestionsDTO getQuestion(List<Integer> questionIds, Integer languageId) throws Exception {

		LanguageEntity languageEntity = languageDao.findById(languageId).get();
		
		String questionLeval = "";
		String status = AppConstant.ACTIVE;

		QuestionsDTO questionsDTO = new QuestionsDTO();
		
	
		if (questionIds == null || questionIds.size() >= 0 && questionIds.size() <= 20) {

			questionLeval = "Easy";

		} else if (questionIds.size() >= 21 && questionIds.size() <= 40) {

			questionLeval = "Nomal";

		} else if (questionIds.size() >= 41 && questionIds.size() <= 60) {

			questionLeval = "Hard";
		} else if (questionIds.size() > 60) {

		} else {

		}

		ArrayList<QuestionEntity>questionEntit = questionDao.findAllQuesIdByQuestionLevalAndStatusAndLanguageEntitiey(questionLeval, status,languageEntity);
		ArrayList<QuestionEntity>questionEntities = questionDao.findAllQuesIdByQuestionLevalAndStatusAndLanguageEntitieyAndQuesIdNotIn(questionLeval, status, languageEntity, questionIds);
		
			if(questionIds.size()==0) {
				questionEntit.forEach(q->{
					
				QuestionEntity questionEntity=questionEntit.get(random.nextInt(questionEntit.size()));
				
				System.out.println(questionEntity.toString());
				System.out.println(questionIds.contains(questionEntity.getQuesId()));
					
				if (questionIds.contains(questionEntity.getQuesId())==false) {
					questionEnt=questionDao.findById(questionEntity.getQuesId()).get();
				}
					
				});
			
		}else {
			questionIds.forEach(each->{
				System.out.println("kkkk");
				QuestionEntity questionEntity=questionEntities.get(random.nextInt(questionEntities.size()));
				if (questionIds.contains(questionEntity.getQuesId())==false) {
					questionEnt=questionDao.findById(questionEntity.getQuesId()).get();
				}
			});
			
		}
		
		System.out.println(questionEnt.getQuesId());
		System.out.println(questionEnt.getQuestion());
		
		System.out.println("Random == = /"+random.toString());
		
		List<AnswerEntity> getAnswersEasy = answerDao.findAllByQuestionEntity(questionEnt);
		List<AnswersDTO> getAllAnsweDto = new ArrayList<AnswersDTO>();

		getAnswersEasy.forEach(answersPrimary -> {
			System.out.println("Loop - 1");
			getAllAnsweDto.add(getAnswerDto(answersPrimary));
		});

		questionsDTO.setQuesId(questionEnt.getQuesId());
		questionsDTO.setQuestion(questionEnt.getQuestion());
		questionsDTO.setMarks(questionEnt.getMarks());

		questionsDTO.setQuestionLeval(questionEnt.getQuestionLeval());
		questionsDTO.setStatus(questionEnt.getStatus());

		questionsDTO.setAnswerDtos(getAllAnsweDto);

		return questionsDTO;

		
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
		List<ExameEntity> exameEntities = exameDao.findByUserNameAndStatus(userName, status);

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
