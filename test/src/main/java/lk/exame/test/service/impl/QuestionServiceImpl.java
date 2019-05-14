package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.AppConstant;
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

	

	@Override
	public boolean delete(Integer quesId) throws Exception {

		QuestionEntity questionEntity = questionDao.findById(quesId).get();

		if (questionEntity != null) {

			questionEntity.setStatus(AppConstant.DEACTIVE);

			questionDao.save(questionEntity);
		}

		return true;
	}

	@Override
	public QuestionsDTO getQuestion(Integer quesId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<QuestionsDTO> getAllQuestion() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveQuestionAnswer(QuestionsDTO questionsDTO) throws Exception {

		System.out.println("Impl subject id =/"+questionsDTO.getSubjectId());
		SubjectEntity subjectEntity = subjectDao.findOneBySubId(questionsDTO.getSubjectId());
		LanguageEntity languageEntity = languageDao.findByLangId(questionsDTO.getLanguageId());
				
		QuestionEntity questionEntity = new QuestionEntity();
		questionEntity.setQuestionQ(questionsDTO.getQuestion());
		questionEntity.setQuestionLeval(questionsDTO.getQuestionLeval());
		questionEntity.setMarks(questionsDTO.getMarks());
		questionEntity.setSubjectEntitiy(subjectEntity);
		questionEntity.setLanguageEntitiey(languageEntity);
		questionEntity.setStatus(AppConstant.ACTIVE);
		QuestionEntity question = questionDao.save(questionEntity);

		if (question != null) {
			questionsDTO.getAnswerDtos().forEach(answers -> {
				AnswerEntity answerEntity = new AnswerEntity();
				/* quesAns = questionRepository.getOne(questionsDTO.getQuesId()); */
				answerEntity.setAnsewer(answers.getAnsewer());
				answerEntity.setTagName(answers.getTagName());
				answerEntity.setCorrect(answers.getCorrect());;
				answerEntity.setQuestionEntity(question);
				answerDao.save(answerEntity);
			});

			
			/*
			 * questionsDTO.getLanguageDto().forEach(language -> { LanguageEntity
			 * languageEntity = new LanguageEntity();
			 * languageEntity.setLangName(language.getLangName());
			 * languageEntity.setQuestionEntity(question);
			 * languageRepository.save(languageEntity); });
			 * 
			 * questionsDTO.getSubjectDto().forEach(subject -> { SubjectEntity subjectEntity
			 * = new SubjectEntity(); subjectEntity.setSubName(subject.getSubName());
			 * subjectEntity.setQuestionEntity(question);
			 * subjectRepository.save(subjectEntity); });
			 * 
			 * 
			 * 
			 * questionsDTO.getExameDetailsDto().forEach(exameDetail ->{ ExameDetailsEntity
			 * exameDetailsEntity = new ExameDetailsEntity();
			 * exameDetailsEntity.setQuestionEntity(question);
			 * exameDetailsEntity.setLevel(exameDetail.getLevel());
			 * exameDetailRepository.save(exameDetailsEntity); });
			 */
			 
			return true;
		}

		return false;
	}

	@Override
	public ArrayList<QuestionsDTO> getAllQuestions() throws Exception {

		String status = AppConstant.ACTIVE;
		List<QuestionEntity> questionEntities = questionDao.findAllByStatus(status);
		ArrayList<QuestionsDTO> getAllQues = new ArrayList<>();

		questionEntities.forEach(e -> {

			getAllQues.add(getAllQuestion(e));

		});

		System.out.println("AllQuestions =/" + getAllQues);

		return getAllQues;
	}

	@Override
	public boolean update(QuestionsDTO questionsDTO) throws Exception {

		QuestionEntity questionEntity = questionDao.findById(questionsDTO.getQuesId()).get();
		
		SubjectEntity subjectEntity = subjectDao.findOneBySubId(questionsDTO.getSubjectId());
		
		LanguageEntity languageEntity = languageDao.findByLangId(questionsDTO.getLanguageId());
		
		/*
		 * SubjectEntity subjectEntity =
		 * subjectRepository.getSubject(questionsDTO.getQuesId());
		 * 
		 * LanguageEntity languageEntity =
		 * languageRepository.getLanguage(questionsDTO.getQuesId());
		 */

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

			
			/*
			 * questionsDTO.getSubjectDto().forEach(subject -> { SubjectEntity subjectEntity
			 * = subjectRepository.getSubject(questionsDTO.getQuesId()); if (subjectEntity
			 * != null) { subjectEntity.setSubName(subject.getSubName());
			 * subjectRepository.save(subjectEntity); } });
			 * 
			 * questionsDTO.getLanguageDto().forEach(langage -> { LanguageEntity
			 * languageEntity = languageRepository.getLanguage(questionsDTO.getQuesId()); if
			 * (languageEntity != null) { languageEntity.setLangName(langage.getLangName());
			 * languageRepository.save(languageEntity); } });
			 */
			/*
			 * subjectEntity.setSubName(questionAnswerDTO.getSubjectDTO().getSubName());
			 * subjectRepository.save(subjectEntity);
			 * 
			 * languageEntity.setLangName(questionAnswerDTO.getLanguageDTO().getLangName());
			 * languageRepository.save(languageEntity);
			 */

		} else {
			System.out.println("Problem Found . . . !");
		}

		return true;

	}

	/*
	 * @Override public QuestionAnswerDTO edit(Integer quesId) throws Exception {
	 * 
	 * QuestionEntity questionEntity = new QuestionEntity(); QuestionsDTO
	 * questionsDTO = new QuestionsDTO();
	 * 
	 * AnswerEntity answerEntity = new AnswerEntity(); AnswersDTO answersDTO = new
	 * AnswersDTO();
	 * 
	 * LanguageEntity languageEntity = new LanguageEntity(); LanguageDTO languageDTO
	 * = new LanguageDTO();
	 * 
	 * SubjectEntity subjectEntity = new SubjectEntity(); SubjectDTO subjectDTO =
	 * new SubjectDTO();
	 * 
	 * questionEntity = questionRepository.findById(quesId).get(); subjectEntity =
	 * subjectRepository.getSubject(quesId); languageEntity =
	 * languageRepository.getLanguage(quesId);
	 * 
	 * 
	 * if (questionEntity != null) {
	 * 
	 * System.out.println("Edit Works Id Passing . . . . ! ");
	 * 
	 * questionsDTO.setQuesId(questionEntity.getQuesId());
	 * questionsDTO.setQuestionQ(questionEntity.getQuestionQ());
	 * questionsDTO.setMarks(questionEntity.getMarks());
	 * questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());
	 * questionsDTO.setLangName(questionEntity.getLangName());
	 * 
	 * List<AnswerEntity> getAnswersEasy =
	 * answerRepository.findAllByQuestionEntity(questionEntity); List<AnswersDTO>
	 * getAllAnsweDto = new ArrayList<>();
	 * 
	 * 
	 * List<SubjectEntity>subjectEntities =
	 * subjectRepository.findAllByQuestionEntity(questionEntity);
	 * List<SubjectDTO>subjectDTOs = new ArrayList<>();
	 * 
	 * List<LanguageEntity>languageEntities =
	 * languageRepository.findAllByQuestionEntity(questionEntity);
	 * List<LanguageDTO>languageDTOs = new ArrayList<>();
	 * 
	 * 
	 * getAnswersEasy.forEach(answersPrimary -> {
	 * getAllAnsweDto.add(getAnswerDto(answersPrimary)); });
	 * 
	 * subjectDTO.setSubId(subjectEntity.getSubId());
	 * subjectDTO.setSubName(subjectEntity.getSubName());
	 * subjectDTO.setQuestionId(subjectEntity.getQuestionEntity().getQuesId());
	 * 
	 * languageDTO.setLangId(languageEntity.getLangId());
	 * languageDTO.setLangName(languageEntity.getLangName());
	 * languageDTO.setQuestionId(languageEntity.getQuestionEntity().getQuesId());
	 * 
	 * QuestionAnswerDTO questionAnswerDTO = new QuestionAnswerDTO();
	 * questionAnswerDTO.setQuestionsDTO(questionsDTO);
	 * questionAnswerDTO.setAnswersDTOs(getAllAnsweDto);
	 * questionAnswerDTO.setSubjectDTO(subjectDTO);
	 * questionAnswerDTO.setLanguageDTO(languageDTO);
	 * 
	 * return questionAnswerDTO;
	 * 
	 * } else {
	 * 
	 * System.out.println("Problem Occred . . . !"); } return null;
	 * 
	 * }
	 */

	private QuestionsDTO getAllQuestion(QuestionEntity questionEntity) {

		QuestionsDTO questionsDTO = new QuestionsDTO();

		questionsDTO.setQuesId(questionEntity.getQuesId());
		questionsDTO.setQuestion(questionEntity.getQuestion());
		questionsDTO.setMarks(questionEntity.getMarks());
		questionsDTO.setStatus(questionEntity.getStatus());
		
		questionsDTO.setQuestionLeval(questionEntity.getQuestionLeval());

		return questionsDTO;
	}

	
	/* (non-Javadoc)
	 * @see lk.exame.test.service.QuestionService#edit(java.lang.Integer)
	 */
	@Override
	public QuestionsDTO edit(Integer quesId) throws Exception {
		
		QuestionEntity questionEntity = new QuestionEntity();
		QuestionsDTO questionsDTO = new QuestionsDTO();
		
	
		  
		  questionEntity = questionDao.findById(quesId).get();
		 
		 
		 
		  if (questionEntity != null) {
		  
		  System.out.println("Edit Works Id Passing . . . . ! ");
		  
		  questionsDTO.setQuesId(questionEntity.getQuesId());
		  questionsDTO.setQuestion(questionEntity.getQuestion());
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
		  getAllAnsweDto.add(getAnswerDto(answersPrimary));
		  });
		  
		  questionsDTO.setAnswerDtos(getAllAnsweDto);
		 
		  
		  return questionsDTO;
		  
		  } else {
		  
		  System.out.println("Problem Occred . . . !");
		  } 
		  
		  return null;
		
	}
	
	private SubjectDTO getSubjectDto(SubjectEntity subjectEntity) {
		
		SubjectDTO subjectDTO = new SubjectDTO();
		
		subjectDTO.setSubId(subjectEntity.getSubId());
		subjectDTO.setSubName(subjectEntity.getSubName());
		
		return subjectDTO;
	}
	
	private LanguageDTO getLanguageDto(LanguageEntity languageEntity) {
		
		LanguageDTO  languageDTO = new LanguageDTO();
		
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
	
	

	
}
