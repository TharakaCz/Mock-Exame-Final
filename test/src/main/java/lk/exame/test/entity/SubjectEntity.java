package lk.exame.test.entity;

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
import javax.persistence.Table;

@Entity
@Table(name="SUBJECT")
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SUBJECT_ID",length = 10)
	private Integer subId;
	
	@Column(name = "SUBJECT_NAME", nullable = false,length = 100)
	private String subName;

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
