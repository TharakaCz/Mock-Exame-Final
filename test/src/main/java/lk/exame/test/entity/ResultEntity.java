package lk.exame.test.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer totalQuestions = 0;
	
	@Column(name = "CORRECT_ANSWERS",length = 60)
	private Integer correctAnswers = 0;
	
	@Column(name = "WRONG_ANSWERS" ,length = 60)
	private Integer wrongAnswers = 0;
	
	@Column(name = "USER_NAME",length =255)
	private String userName;
	
	@Column(name = "EXAME_DATE",length = 50)
	private Date exameDate;
	


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

	
	
	
}
