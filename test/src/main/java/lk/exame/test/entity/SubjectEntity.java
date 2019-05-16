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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBJECT_ID",length = 10)
	private Integer subId;
	
	/**
	 * String subName
	 * 
	 * Set And Get Subject Name Not Null , length 100
	 */
	@Column(name = "SUBJECT_NAME", nullable = false,length = 100)
	private String subName;

	/**
	 * List<QuestionEntity>questionEntities
	 * 
	 * mappedBy Language Table Target by Question Table
	 */
	@OneToMany(mappedBy="subjectEntitiy",targetEntity = QuestionEntity.class)
	private List<QuestionEntity>questionEntities;
	
	
	public SubjectEntity() {
		
	}

	
	public SubjectEntity(String subName) {
		this.subName = subName;
	}


	public SubjectEntity(Integer subId, String subName) {

		this.subId = subId;
		this.subName = subName;
	}

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	
	


	public List<QuestionEntity> getQuestionEntities() {
		return questionEntities;
	}


	public void setQuestionEntities(List<QuestionEntity> questionEntities) {
		this.questionEntities = questionEntities;
	}


	@Override
	public String toString() {
		return "SubjectEntity [subId=" + subId + ", subName=" + subName + "]";
	}
	
	
}
