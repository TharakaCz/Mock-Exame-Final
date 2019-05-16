package lk.exame.test.dto;

import java.util.Date;
import java.util.List;

import lk.exame.test.entity.ExameDetailsEntity;

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
	
	private Date exameDate;
	
	private String startTime;
	
	private String endTime;
	
	private String language;
	
	private String userName;

	private List<ExameDetailsEntity>exameDetailsEntities;

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

	
	public Date getExameDate() {
		return exameDate;
	}

	public void setExameDate(Date exameDate) {
		this.exameDate = exameDate;
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

	public List<ExameDetailsEntity> getExameDetailsEntities() {
		return exameDetailsEntities;
	}

	public void setExameDetailsEntities(List<ExameDetailsEntity> exameDetailsEntities) {
		this.exameDetailsEntities = exameDetailsEntities;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
