package lk.exame.test.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESULT")
public class ResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESULT_ID",length = 10)
	private Integer resultId;
	
	@Column(name="TOTAL",length = 100)
	private Integer total;
	
	@Column(name = "TOTAL_QUESTIONS",length = 60)
	private Integer totalQuestions;
	
	@Column(name = "CORRECT_ANSWERS",length = 60)
	private Integer correctAnswers;
	
	@Column(name = "WRONG_ANSWERS" ,length = 60)
	private Integer wrongAnswers;
	
	@Column(name = "USER_NAME",length =255)
	private String userName;
	
	@Column(name = "EXAME_DATE",length = 50)
	private Date exameDate;
	
	@Column(name = "START_TIME",length = 50)
	private String startTime;
	
	@Column(name = "END_TIME",length = 50)
	private String endTime;
	

	public ResultEntity() {
		
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
}
