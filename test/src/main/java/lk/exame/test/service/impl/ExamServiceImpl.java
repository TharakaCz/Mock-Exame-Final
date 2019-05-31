package lk.exame.test.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.AnswerDAO;
import lk.exame.test.dao.ExamDAO;
import lk.exame.test.dao.LanguageDAO;
import lk.exame.test.dao.QuestionDAO;
import lk.exame.test.dao.ResultDAO;
import lk.exame.test.dto.ExamDTO;

import lk.exame.test.dto.ExamBasicDetailDTO;

import lk.exame.test.dto.ResultDTO;
import lk.exame.test.dto.SubmitQuestionDTO;
import lk.exame.test.entity.AnswerEntity;
import lk.exame.test.entity.ExamEntity;
import lk.exame.test.entity.LanguageEntity;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.ResultEntity;
import lk.exame.test.service.ExamService;
import lk.exame.test.utill.AppConstant;

/**
 * 
 * @author Tharaka Chandralal
 */
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private QuestionDAO questionDao;

	@Autowired
	private ExamDAO examDao;

	@Autowired
	private AnswerDAO answerDao;

	@Autowired
	private ResultDAO resultDao;

	@Autowired
	private LanguageDAO languageDao;
	
	@Value("${app.examQuestion}")
	private String examQuestion;
	
	@Value("${app.examTime}")
	private String examTime;
	
	@Value("${app.examOneQuestionMark}")
	private String examOneQuestionMark;
	
	@Value("${app.examDpass}")
	private String examDpass;
	
	@Value("${app.examBpass}")
	private String examBpass;
	
	@Value("${app.examCpass}")
	private String examCpass;
	
	@Value("${app.examSpass}")
	private String examSpass;
	
	@Value("${app.examTotalQuestionMarks}")
	private String totalQuestionMarks;
	
	/**
	 * This Are Using Active Table Row DeActive In Table
	 */
	@Override
	public boolean delete(Integer examId) throws Exception {
		ExamEntity examEntity = examDao.findByExamId(examId);
		
		if (examEntity !=null) {
			examEntity.setStatus(AppConstant.DEACTIVE);
		}else {
			System.out.println("Exame Table Is Empty");
		}
		
		return true;
	}


	

	/**
	 * This Method Using Calculate Exam Result
	 */
	@Override
	public ResultDTO submitQuestion(List<SubmitQuestionDTO> submitQuestionDTOs, String userName, Integer languageId)
			throws Exception {

		Integer exameQuestionCount = Integer.parseInt(examQuestion);
		Integer dPass = Integer.parseInt(examDpass);
		Integer bPass = Integer.parseInt(examBpass);
		Integer cPass = Integer.parseInt(examCpass);
		Integer sPass = Integer.parseInt(examSpass);
		Integer exameTotalMarks = Integer.parseInt(totalQuestionMarks);
		
		BigDecimal exameTotal = new BigDecimal(exameTotalMarks);
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		String time = formatter.format(date);

		SimpleDateFormat formatterDate = new SimpleDateFormat();
		Date dateDate = new SimpleDateFormat("dd/MM/yyyy").parse(formatterDate.format(date));

		ExamEntity examEntity = new ExamEntity();

		LanguageEntity languageEntity = languageDao.findByLangId(languageId);

		examEntity.setUserName(userName);
		examEntity.setExamDate(dateDate);
		examEntity.setRegDate(dateDate);
		examEntity.setRegTime(time);
		examEntity.setStartTime(time);
		examEntity.setLanguageEntity(languageEntity);
		examEntity.setStatus(AppConstant.ACTIVE);

		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setExamDate(new Date());
		resultEntity.setUserName(userName);

		submitQuestionDTOs.forEach(subQues -> {

			System.out.println("Called submitQuestion . . . . ");

			if (resultEntity.getTotalQuestions() == null) {
				System.out.println("Total Ques Contition Ok . . . . ");
				resultEntity.setTotalQuestions(1);

			} else {
				System.out.println("Total Ques Else Work");
				Integer totalQues = resultEntity.getTotalQuestions();
				totalQues++;
				resultEntity.setTotalQuestions(totalQues);
			}

			System.out.println("Total question = =/" + resultEntity.toString());

			QuestionEntity questionEntity = questionDao.findByQuesId(subQues.getQuestionId());

			AnswerEntity answerEntity = answerDao.findByAnswerId(subQues.getUserAnswerId());

			if (answerEntity.getCorrect().equals(1)) {
				System.out.println("Loop isCorrect ok . .");
				resultEntity.setCorrectAnswers(resultEntity.getCorrectAnswers() + 1);

				if (resultEntity.getTotal() == null) {

					resultEntity.setTotal(questionEntity.getMarks());

				} else {

					resultEntity.setTotal(resultEntity.getTotal() + questionEntity.getMarks());
					
					

				}

			} else if (answerEntity.getCorrect().equals(0)) {
				resultEntity.setWrongAnswers(resultEntity.getWrongAnswers() + 1);
			}
		});

		System.out.println("Result Total =/"+resultEntity.getTotal());
		
		if (resultEntity.getTotal() == dPass || resultEntity.getTotal() > dPass) {
			resultEntity.setExamePassGrade(AppConstant.DPASS);
			resultEntity.setPassFail(AppConstant.PASS);
			
		}else if (resultEntity.getTotal() == bPass || resultEntity.getTotal() < dPass && resultEntity.getTotal() > bPass) {
			resultEntity.setExamePassGrade(AppConstant.BPASS);
			resultEntity.setPassFail(AppConstant.PASS);
			
		}else if (resultEntity.getTotal() == cPass || resultEntity.getTotal() < bPass && resultEntity.getTotal() > cPass) {
			resultEntity.setExamePassGrade(AppConstant.CPASS);
			resultEntity.setPassFail(AppConstant.PASS);
			
		}else if (resultEntity.getTotal() == sPass || resultEntity.getTotal() < cPass && resultEntity.getTotal() > sPass) {
			resultEntity.setExamePassGrade(AppConstant.SPASS);
			resultEntity.setPassFail(AppConstant.FAIL);
			
		}else {
			resultEntity.setExamePassGrade(AppConstant.FPASS);
			resultEntity.setPassFail(AppConstant.FAIL);
		}
		
		BigDecimal prcentage = new BigDecimal(0);
		
		prcentage = (new BigDecimal(resultEntity.getTotal()).multiply(exameTotal)).divide(exameTotal,2,RoundingMode.HALF_UP);
		
		resultEntity.setExameTotalPresent(prcentage);
		
		examEntity.setResultEntity(resultDao.save(resultEntity));

		examDao.save(examEntity);

		String language = languageEntity.getLangName();

		ResultDTO resultDTO = new ResultDTO();

		resultDTO.setResultId(resultEntity.getResultId());
		resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());
		resultDTO.setExamDate(resultEntity.getExamDate());
		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setUserName(resultEntity.getUserName());
		resultDTO.setLanguage(language);
		resultDTO.setExamePassGrade(resultEntity.getExamePassGrade());
		resultDTO.setExameTotalPresent(resultEntity.getExameTotalPresent());
		resultDTO.setTotalExameQuestions(exameQuestionCount);
		resultDTO.setPassFail(resultEntity.getPassFail());
		return resultDTO;
	}

	/**
	 * This Method Get All Exams In Database Using UserName
	 */
	@Override
	public ArrayList<ExamDTO> getExamId(String userName) throws Exception {

		String status = AppConstant.ACTIVE;
		List<ExamEntity> examEntities = examDao.findByUserNameAndStatus(userName, status);
		ArrayList<ExamDTO> examDTOs = new ArrayList<>();

		examEntities.forEach(e -> {
			examDTOs.add(getExameAll(e));
		});
		return examDTOs;
	}

	private ExamDTO getExameAll(ExamEntity examEntity) {

		ExamDTO examDTO = new ExamDTO();

		examDTO.setExamId(examEntity.getExamId());
		examDTO.setExameDate(examEntity.getExamDate());
		examDTO.setUserName(examEntity.getUserName());
		examDTO.setUserName(examEntity.getUserName());
		examDTO.setRegDate(examEntity.getRegDate());

		examDTO.setRegTime(examEntity.getRegTime());

		return examDTO;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * This Method Using Get Exam Result in Exam Table using Exam Id
	 * 
	 * @see lk.exam.test.service.ExamService#getExamResult(java.lang.Integer)
	 */
	@Override
	public ResultDTO getExamResult(Integer examId) throws Exception {

		ExamEntity examEntity = examDao.findFirst1ByExamId(examId);

		Integer resultId = examEntity.getResultEntity().getResultId();

		ResultEntity resultEntity = resultDao.findByResultId(resultId);
		ResultDTO resultDTO = new ResultDTO();

		resultDTO.setCorrectAnswers(resultEntity.getCorrectAnswers());

		resultDTO.setExamDate(resultEntity.getExamDate());
		resultDTO.setResultId(resultEntity.getResultId());

		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());

		return resultDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * This Method using get All Result in Result Table Using UserName
	 * 
	 * @see
	 * lk.exam.test.service.ExamService#getResultByExamUserName(java.lang.String)
	 */
	@Override
	public ArrayList<ResultDTO> getResultByExamUserName(String userName) throws Exception {

		String status = AppConstant.ACTIVE;
		List<ExamEntity> examEntities = examDao.findByUserNameAndStatus(userName, status);

		ArrayList<Integer> examDTOs = new ArrayList<>();

		examEntities.forEach(e -> {
			examDTOs.add(e.getResultEntity().getResultId());
		});

		List<ResultEntity> resultEntities = (List<ResultEntity>) resultDao.findAllById(examDTOs);

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

		resultDTO.setExamDate(resultEntity.getExamDate());
		resultDTO.setTotal(resultEntity.getTotal());
		resultDTO.setTotalQuestions(resultEntity.getTotalQuestions());
		resultDTO.setWrongAnswers(resultEntity.getWrongAnswers());

		return resultDTO;
	}




	/* (non-Javadoc)
	 * @see lk.exame.test.service.ExamService#returnBacicDetails(lk.exame.test.dto.ExameBasicDetailDTO)
	 */
	@Override
	public ExamBasicDetailDTO returnBacicDetails(ExamBasicDetailDTO examBasicDetailDTO) throws Exception {
		
		Integer examQuestionLimit = Integer.parseInt(examQuestion);
		Integer examTimeCount = Integer.parseInt(examTime);
		Integer examQuestionMarks = Integer.parseInt(examOneQuestionMark);
		
		List<Integer>questionMarksList = new ArrayList<Integer>();
		questionMarksList.add(examQuestionMarks);
		
		examBasicDetailDTO.setExameQuestionLimit(examQuestionLimit);
		examBasicDetailDTO.setExameTimeCout(examTimeCount);
		examBasicDetailDTO.setExamQuestionMarks(questionMarksList);
		
		return examBasicDetailDTO;
	}

}
