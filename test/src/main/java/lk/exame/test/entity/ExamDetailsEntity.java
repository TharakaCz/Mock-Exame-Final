package lk.exame.test.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

/**
 * 
 * @author Tharaka Chandralal
 */
@Entity
@Table(name = "EXAM_DETAIL")
public class ExamDetailsEntity {

	/**
	 * Integer exameDetailId
	 * 
	 * Generate ExamDetailId In ExamDetail Table From Database , length 10
	 */
	private Integer examDetailId;
	
	/**
	 * String level
	 * 
	 * Set And Get Level , length 20
	 */
	private String level;
	
	/**
	 * String enable
	 * 
	 * Set And Get Enable
	 */
	private String enable;


	/**
	 * QuestionEntity questionEntity
	 * 
	 * Join Question Table In ExamDetail Table using Question Id
	 */
	private QuestionEntity questionEntity;
	
	/**
	 * ExamEntity examEntity
	 * 
	 * Join Exam Table In ExamDetail Table using exam Id
	 */
	private ExamEntity examEntity;
	
	/**
	 * AnswerEntity answerEntity
	 * 
	 * Join Answer Table In ExamDetail Table using answer Id
	 */
	private AnswerEntity answerEntity;

	
	public ExamDetailsEntity() {
	
	}

	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "EXAM_DETAIL_ID",length = 10)
	public Integer getExamDetailId() {
		return examDetailId;
	}

	public void setExamDetailId(Integer examDetailId) {
		this.examDetailId = examDetailId;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTION_ID", nullable = false)
	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EXAM_ID",nullable = false)
	public ExamEntity getExamEntity() {
		return examEntity;
	}

	public void setExamEntity(ExamEntity examEntity) {
		this.examEntity = examEntity;
	}

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ANSWER_ID",nullable = false)
	public AnswerEntity getAnswerEntity() {
		return answerEntity;
	}

	public void setAnswerEntity(AnswerEntity answerEntity) {
		this.answerEntity = answerEntity;
	}

	@Column(name = "LEVEL",length = 20)
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "ENABLE",length = 20)
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	
	
	
}
