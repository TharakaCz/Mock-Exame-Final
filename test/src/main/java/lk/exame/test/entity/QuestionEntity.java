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
@Table(name="QUESTION")
public class QuestionEntity {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "QUES_ID",length = 10)
	private Integer quesId;
	
	@Column(name = "QUESTION",length = 255 , nullable = false)
	private String question;
	
	@Column(name = "MARKS",length=10,nullable = true)
	private Integer marks;
	
	@Column(name = "QUESTION_LEVAL" , length = 50)
	private String questionLeval;
	
	
	@Column(name = "STATUS",length = 20)
	private String status;
	
	@OneToMany(mappedBy = "questionEntity",targetEntity = AnswerEntity.class)
	private List<AnswerEntity>answerEntities;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="LANGUAGE_ID",nullable= false)
	private LanguageEntity languageEntitiey;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBJECT_ID",nullable= false)
	private SubjectEntity subjectEntitiy;
	
	public QuestionEntity() {
		
	}


	public Integer getQuesId() {
		return quesId;
	}

	public void setQuesId(Integer quesId) {
		this.quesId = quesId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestionQ(String question) {
		this.question = question;
	}

	public List<AnswerEntity> getAnswerEntities() {
		return answerEntities;
	}

	public void setAnswerEntities(List<AnswerEntity> answerEntities) {
		this.answerEntities = answerEntities;
	}

	
	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public String getQuestionLeval() {
		return questionLeval;
	}

	public void setQuestionLeval(String questionLeval) {
		this.questionLeval = questionLeval;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LanguageEntity getLanguageEntitiey() {
		return languageEntitiey;
	}


	public void setLanguageEntitiey(LanguageEntity languageEntitiey) {
		this.languageEntitiey = languageEntitiey;
	}


	public SubjectEntity getSubjectEntitiy() {
		return subjectEntitiy;
	}


	public void setSubjectEntitiy(SubjectEntity subjectEntitiy) {
		this.subjectEntitiy = subjectEntitiy;
	}
	
	
	
	
}
