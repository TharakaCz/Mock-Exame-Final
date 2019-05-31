package lk.exame.test.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lk.exame.test.entity.ExamDetailsEntity;

/**
 * 
 * @author Tharaka Chandralal
 */
public class ResultDTO {

	private Integer resultId;
	
	private Integer total;
	
	private Integer totalQuestions;
	
	private Integer correctAnswers;
	
	private Integer wrongAnswers;
	
	private Date examDate;
	
	private String startTime;
	
	private String endTime;
	
	private String language;
	
	private String userName;

	private List<ExamDetailsEntity>examDetailsEntities;

	private String passFail;
	
	private String examePassGrade;
	
	private BigDecimal exameTotalPresent;
	
	private Integer totalExameQuestions;
	
	public ResultDTO() {
		
	}

	
	public Integer getResultId() {
		return resultId;
	}


	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}


	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public Integer getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(Integer correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public Integer getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(Integer wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}


	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<ExamDetailsEntity> getExameDetailsEntities() {
		return examDetailsEntities;
	}

	public void setExameDetailsEntities(List<ExamDetailsEntity> examDetailsEntities) {
		this.examDetailsEntities = examDetailsEntities;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassFail() {
		return passFail;
	}


	public void setPassFail(String passFail) {
		this.passFail = passFail;
	}


	public String getExamePassGrade() {
		return examePassGrade;
	}


	public void setExamePassGrade(String examePassGrade) {
		this.examePassGrade = examePassGrade;
	}


	public BigDecimal getExameTotalPresent() {
		return exameTotalPresent;
	}


	public void setExameTotalPresent(BigDecimal exameTotalPresent) {
		this.exameTotalPresent = exameTotalPresent;
	}


	public Integer getTotalExameQuestions() {
		return totalExameQuestions;
	}


	public void setTotalExameQuestions(Integer totalExameQuestions) {
		this.totalExameQuestions = totalExameQuestions;
	}
	
	
}
