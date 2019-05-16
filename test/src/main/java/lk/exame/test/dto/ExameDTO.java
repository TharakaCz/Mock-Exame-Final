package lk.exame.test.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Tharaka Chandralal
 */
public class ExameDTO {

	private Integer exameId; 
	
	private Date exameDate;  
	
	private String startTime;
	
	private String endTime; 
	
	private String userName;

	private Date regDate;
	
	private String regTime;
	
	
	private List<ExameDetailsDTO>exameDetailsEntities;
	
	public ExameDTO() {
		
	}

	public Integer getExameId() {
		return exameId;
	}

	public void setExameId(Integer exameId) {
		this.exameId = exameId;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public List<ExameDetailsDTO> getExameDetailsEntities() {
		return exameDetailsEntities;
	}

	public void setExameDetailsEntities(List<ExameDetailsDTO> exameDetailsEntities) {
		this.exameDetailsEntities = exameDetailsEntities;
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
