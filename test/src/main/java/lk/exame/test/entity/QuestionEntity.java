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

/**
 * 
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="QUESTION")
public class QuestionEntity {
	
	/**
	 * Integer quesId
	 * 
	 * Generate QuestionId In Question Table From Database , length 10
	 */
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "QUES_ID",length = 10)
	private Integer quesId;
	
	/**
	 * String question
	 * 
	 * Get And Set Question In Question Table From Database not null , length 255
	 */
	@Column(name = "QUESTION",length = 255 , nullable = false)
	private String question;
	
	/**
	 * Integer marks
	 * 
	 * Get And Set Marks One Question In Question Table From Database not null , length 10
	 */
	@Column(name = "MARKS",length=10,nullable = false)
	private Integer marks;
	
	/**
	 * String questionLeval
	 * 
	 * Get And Set QuestionLeval One Question In Question Table From Database , length 50
	 */
	@Column(name = "QUESTION_LEVAL" , length = 50)
	private String questionLeval;
	
	/**
	 * String status
	 * 
	 * Set And Get Question Status In Question Table From Database , length 20
	 */
	@Column(name = "STATUS",length = 20)
	private String status;
	
	/**
	 * List<AnswerEntity>answerEntities
	 * 
	 * One To Many Mapping By Question Table In Answer Table Using Question Id
	 */
	@OneToMany(mappedBy = "questionEntity",targetEntity = AnswerEntity.class)
	private List<AnswerEntity>answerEntities;
	
	/**
	 * LanguageEntity languageEntitiey
	 * 
	 * Join Language Id Column In Question Table
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="LANGUAGE_ID",nullable= false)
	private LanguageEntity languageEntitiey;
	
	/**
	 * SubjectEntity subjectEntitiy
	 * 
	 * Join Subject Id Column In Question Table
	 */
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
