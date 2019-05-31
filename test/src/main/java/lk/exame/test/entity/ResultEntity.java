package lk.exame.test.entity;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author Tharaka Chandralal
 */
@Entity
@Table(name = "RESULT")
public class ResultEntity {

	/**
	 * Integer resultId
	 * 
	 * Generate Result Id In Result Table From Database , length 10
	 */
	private Integer resultId;
	
	/**
	 * Integer total
	 * 
	 * Calculate Total Marks In Written Exams , length 100
	 */
	private Integer total;
	
	/**
	 * Integer totalQuestions
	 * 
	 * Calculate User Get Total Questions , length 60
	 */
	private Integer totalQuestions = 0;
	
	/**
	 * Integer correctAnswers
	 * 
	 * 	Calculate Total Correct Answers In Exams ,  length 60
	 */
	private Integer correctAnswers = 0;
	
	/**
	 * Integer wrongAnswers
	 * 
	 * Calculate Total Wrong Answers In Exams , length 60
	 */
	private Integer wrongAnswers = 0;
	
	/**
	 * String userName
	 *  
	 * Set Exam Written  UserName In Result Table From Database , length 255
	 */
	
	private String userName;
	
	/**
	 * Date exameDate
	 * 
	 * Set Exam Written Date In Result Table From  Database , length 50
	 */
	private Date examDate;
	
	private String passFail;
	
	private String examePassGrade;
	
	private BigDecimal exameTotalPresent;
	
	private String status;
	
	public ResultEntity() {
		
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RESULT_ID",length = 10)
	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	@Column(name="TOTAL",length = 100)
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Column(name = "TOTAL_QUESTIONS",length = 60)
	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	
	@Column(name = "CORRECT_ANSWERS",length = 60)
	public Integer getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(Integer correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	@Column(name = "WRONG_ANSWERS" ,length = 60)
	public Integer getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(Integer wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	@Column(name = "USER_NAME",length =255)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Column(name = "EXAM_DATE",length = 50)
	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}


	@Column(name="PASS_FAIL")
	public String getPassFail() {
		return passFail;
	}


	public void setPassFail(String passFail) {
		this.passFail = passFail;
	}


	@Column(name="EXAME_GRADE")
	public String getExamePassGrade() {
		return examePassGrade;
	}


	public void setExamePassGrade(String examePassGrade) {
		this.examePassGrade = examePassGrade;
	}

	@Column(name="EXAME_PRESENT")
	public BigDecimal getExameTotalPresent() {
		return exameTotalPresent;
	}


	public void setExameTotalPresent(BigDecimal exameTotalPresent) {
		this.exameTotalPresent = exameTotalPresent;
	}


	@Column(name="STATUS",length=15)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	

	
	
	
	
}
