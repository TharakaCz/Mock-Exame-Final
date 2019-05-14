package lk.exame.test.dto;

import java.util.List;

public class QuestionsDTO {

	private Integer quesId;
	private String question;
	private Integer marks;
	private String questionLeval;
	private String status;
	
	private Integer languageId;
	private Integer subjectId;
	private List<AnswersDTO>answerDtos;
	private LanguageDTO languageDto;
	private SubjectDTO subjectDto;
	
	/* private List<ExameDetailsDTO>exameDetailsDto; */
	
	public QuestionsDTO() {
		
	}

	public Integer getQuesId() {
		return quesId;
	}
	
	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	/*
	 * public List<ExameDetailsDTO> getExameDetailsDto() { return exameDetailsDto; }
	 * 
	 * 
	 * public void setExameDetailsDto(List<ExameDetailsDTO> exameDetailsDto) {
	 * this.exameDetailsDto = exameDetailsDto; }
	 */


	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getQuestionLeval() {
		return questionLeval;
	}

	public void setQuestionLeval(String questionLeval) {
		this.questionLeval = questionLeval;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public List<AnswersDTO> getAnswerDtos() {
		return answerDtos;
	}

	public void setAnswerDtos(List<AnswersDTO> answerDtos) {
		this.answerDtos = answerDtos;
	}

	public LanguageDTO getLanguageDto() {
		return languageDto;
	}

	public void setLanguageDto(LanguageDTO languageDto) {
		this.languageDto = languageDto;
	}

	public SubjectDTO getSubjectDto() {
		return subjectDto;
	}

	public void setSubjectDto(SubjectDTO subjectDto) {
		this.subjectDto = subjectDto;
	}

	
}
