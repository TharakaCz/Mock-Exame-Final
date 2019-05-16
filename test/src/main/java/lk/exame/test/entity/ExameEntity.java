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

/**
 * 
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="EXAME")
public class ExameEntity {

	/**
	 * Integer exameId
	 * 
	 * Generate Exam Id In Exam Table From Database , length 10
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EXAME_ID",length = 10)
	private Integer exameId;
	
	/**
	 * Date exameDate
	 * 
	 * Set And Get Exam Date in Exam Table
	 */
	@Column(name = "EXAME_DATE")
	private Date exameDate;
	
	/**
	 * String startTime
	 * 
	 * Set And Get Start Time in Exam Table
	 */
	@Column(name = "START_TIME")
	private String startTime;
	
	/**
	 * String endTime
	 *  
	 * Set And Get Exam End Time in Exam Table
	 */
	@Column(name = "END_TIME")
	private String endTime;
	
	/**
	 * String userName
	 * 
	 * Set And Get UserName in Exam Table , length 100 , not null
	 */
	@Column(name = "USER_NAME",length = 100 , nullable = false)
	private String userName;
	
	/**
	 * Date regDate
	 * 
	 * Set And Get Exam Registration Time in Exam Table
	 */
	@Column(name = "REGISTATION_DATE")
	private Date regDate;
	
	/**
	 * String regTime
	 * 
	 * Set And Get Exam Registration Time in Exam Table
	 */
	@Column(name = "REGISTATION_TIME")
	private String regTime;

	/**
	 * String status
	 * 
	 * Set And Get Exam Status In Exam Table
	 */
	@Column(name = "STATUS")
	private String status;
	
	/**
	 * LanguageEntity languageEntity
	 * 
	 * Join Language Table From Exam Table Using Language Id
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "lANGUAGE_ID")
	private LanguageEntity languageEntity;

	/**
	 * List<ExameDetailsEntity>exameDetailsEntities
	 * 
	 * mappedBy Exam Table In ExameDetail Table 
	 */
	@OneToMany(mappedBy = "exameEntity",targetEntity = ExameDetailsEntity.class)
	private List<ExameDetailsEntity>exameDetailsEntities;
	
	/**
	 * ResultEntity resultEntity
	 * 
	 * One To Many Relation Mapped By Result Table From Exam Table Using Result Id
	 */
	@OneToOne(cascade=CascadeType.ALL)
	private ResultEntity resultEntity;
	
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
	
	public ResultEntity getResultEntity() {
		return resultEntity;
	}

	public void setResultEntity(ResultEntity resultEntity) {
		this.resultEntity = resultEntity;
	}
	
}
