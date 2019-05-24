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
@Table(name="EXAM")
public class ExamEntity {

	/**
	 * Integer examId
	 * 
	 * Generate Exam Id In Exam Table From Database , length 10
	 */
	private Integer examId;
	
	/**
	 * Date examDate
	 * 
	 * Set And Get Exam Date in Exam Table
	 */
	private Date examDate;
	
	/**
	 * String startTime
	 * 
	 * Set And Get Start Time in Exam Table
	 */
	private String startTime;
	
	/**
	 * String endTime
	 *  
	 * Set And Get Exam End Time in Exam Table
	 */
	private String endTime;
	
	/**
	 * String userName
	 * 
	 * Set And Get UserName in Exam Table , length 100 , not null
	 */
	private String userName;
	
	/**
	 * Date regDate
	 * 
	 * Set And Get Exam Registration Time in Exam Table
	 */
	private Date regDate;
	
	/**
	 * String regTime
	 * 
	 * Set And Get Exam Registration Time in Exam Table
	 */
	private String regTime;

	/**
	 * String status
	 * 
	 * Set And Get Exam Status In Exam Table
	 */
	private String status;
	

	/**
	 * LanguageEntity languageEntity
	 * 
	 * Join Language Table From Exam Table Using Language Id
	 */
	private LanguageEntity languageEntity;

	/**
	 * List<ExamDetailsEntity>examDetailsEntities
	 * 
	 * mappedBy Exam Table In ExamDetail Table 
	 */
	private List<ExamDetailsEntity>examDetailsEntities;
	
	/**
	 * ResultEntity resultEntity
	 * 
	 * One To Many Relation Mapped By Result Table From Exam Table Using Result Id
	 */
	private ResultEntity resultEntity;
	
	public ExamEntity() {
		
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EXAM_ID",length = 10)
	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "EXAM_DATE")
	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	
	@Column(name = "START_TIME")
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "END_TIME")
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "lANGUAGE_ID")
	public LanguageEntity getLanguageEntity() {
		return languageEntity;
	}

	public void setLanguageEntity(LanguageEntity languageEntity) {
		this.languageEntity = languageEntity;
	}

	
	@OneToMany(mappedBy = "examEntity",targetEntity = ExamDetailsEntity.class)
	public List<ExamDetailsEntity> getExamDetailsEntities() {
		return examDetailsEntities;
	}

	public void setExamDetailsEntities(List<ExamDetailsEntity> examDetailsEntities) {
		this.examDetailsEntities = examDetailsEntities;
	}

	
	@Column(name = "REGISTATION_DATE")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Column(name = "REGISTATION_TIME")
	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="RESULT_ID")
	public ResultEntity getResultEntity() {
		return resultEntity;
	}

	public void setResultEntity(ResultEntity resultEntity) {
		this.resultEntity = resultEntity;
	}
	
}
