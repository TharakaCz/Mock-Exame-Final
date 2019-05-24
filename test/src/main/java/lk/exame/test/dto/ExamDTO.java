package lk.exame.test.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Tharaka Chandralal
 */
public class ExamDTO {

	private Integer examId; 
	
	private Date examDate;  
	
	private String startTime;
	
	private String endTime; 
	
	private String userName;

	private Date regDate;
	
	private String regTime;
	
	
	private List<ExamDetailsDTO>examDetailsEntities;
	
	public ExamDTO() {
		
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Date getExameDate() {
		return examDate;
	}

	public void setExameDate(Date examDate) {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public List<ExamDetailsDTO> getExamDetailsEntities() {
		return examDetailsEntities;
	}

	public void setExamDetailsEntities(List<ExamDetailsDTO> examDetailsEntities) {
		this.examDetailsEntities = examDetailsEntities;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
	
}
