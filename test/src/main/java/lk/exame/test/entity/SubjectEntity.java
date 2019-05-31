package lk.exame.test.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="SUBJECT")
public class SubjectEntity {

	/**
	 * Integer subId
	 * 
	 * Generate Subject Id In Subject Table From Database , length 10
	 */
	
	private Integer subId;
	
	/**
	 * String subName
	 * 
	 * Set And Get Subject Name Not Null , length 100
	 */
	private String subName;

	/**
	 * List<QuestionEntity>questionEntities
	 * 
	 * mappedBy Language Table Target by Question Table
	 */
	private List<QuestionEntity>questionEntities;
	
	private String status;
	
	public SubjectEntity() {
		
	}

	
	public SubjectEntity(String subName) {
		this.subName = subName;
	}


	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBJECT_ID",length = 10)
	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	
	@Column(name = "SUBJECT_NAME", nullable = false,length = 100)
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	
	@OneToMany(mappedBy="subjectEntitiy",targetEntity = QuestionEntity.class)
	public List<QuestionEntity> getQuestionEntities() {
		return questionEntities;
	}


	public void setQuestionEntities(List<QuestionEntity> questionEntities) {
		this.questionEntities = questionEntities;
	}


	@Column(name="STATUS",length=10)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "SubjectEntity [subId=" + subId + ", subName=" + subName + "]";
	}
	
	
}
