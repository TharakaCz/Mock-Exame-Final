package lk.exame.test.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EXAME")
public class ExameEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EXAME_ID",length = 10)
	private Integer exameId;
	
	@Column(name = "EXAME_DATE")
	private Date exameDate;
	
	@Column(name = "START_TIME")
	private String startTime;
	
	@Column(name = "END_TIME")
	private String endTime;
	
	@Column(name = "USER_NAME",length = 100 , nullable = false)
	private String userName;
	
	@Column(name = "REGISTATION_DATE")
	private Date regDate;
	
	@Column(name = "REGISTATION_TIME")
	private String regTime;

	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "lANGUAGE_ID")
	private LanguageEntity languageEntity;

	@OneToMany(mappedBy = "exameEntity",targetEntity = ExameDetailsEntity.class)
	private List<ExameDetailsEntity>exameDetailsEntities;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ResultEntity resultEntity;
	
	
	public ResultEntity getResultEntity() {
		return resultEntity;
	}

	public void setResultEntity(ResultEntity resultEntity) {
		this.resultEntity = resultEntity;
	}

	public ExameEntity() {
		
	}

	public Integer getExameId() {
		return exameId;
	}

	public void setExameId(Integer exameId) {
		this.exameId = exameId;
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

	

	public LanguageEntity getLanguageEntity() {
		return languageEntity;
	}

	public void setLanguageEntity(LanguageEntity languageEntity) {
		this.languageEntity = languageEntity;
	}

	public List<ExameDetailsEntity> getExameDetailsEntities() {
		return exameDetailsEntities;
	}

	public void setExameDetailsEntities(List<ExameDetailsEntity> exameDetailsEntities) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
