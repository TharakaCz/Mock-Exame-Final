package lk.exame.test.dto;

/**
 * 
 * @author Tharaka Chandralal
 */
public class AnswersDTO {

	private Integer answerId;
	
	private String ansewer;
	
	private String tagName;
	
	private Integer correct;
	
	private Integer questionId;

	private boolean checkStatus;
	
	public AnswersDTO() {
		
	}
	
	public AnswersDTO(Integer answerId) {
		this.answerId = answerId;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getAnsewer() {
		return ansewer;
	}

	public void setAnsewer(String ansewer) {
		this.ansewer = ansewer;
	}

	

	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	
	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	
	public boolean isCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	@Override
	public String toString() {
		return "AnswersDTO [answerId=" + answerId + ", ansewer=" + ansewer + ", trueFalse=" 
				+ ", questionId=" + questionId + "]";
	}


	
	
	
}
