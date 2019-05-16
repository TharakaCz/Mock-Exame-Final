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
@Table(name = "EXAME_DETAIL")
public class ExameDetailsEntity {

	/**
	 * Integer exameDetailId
	 * 
	 * Generate ExameDetailId In ExameDetail Table From Database , length 10
	 */
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "EXAME_DETAIL_ID",length = 10)
	private Integer exameDetailId;
	
	/**
	 * String level
	 * 
	 * Set And Get Level , length 20
	 */
	@Column(name = "LEVEL",length = 20)
	private String level;
	
	/**
	 * String enable
	 * 
	 * Set And Get Enable
	 */
	@Column(name = "ENABLE",length = 20)
	private String enable;

	/**
	 * QuestionEntity questionEntity
	 * 
	 * Join Question Table In ExameDetail Table using Question Id
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTION_ID", nullable = false)
	private QuestionEntity questionEntity;
	
	/**
	 * ExameEntity exameEntity
	 * 
	 * Join Exam Table In ExameDetail Table using exam Id
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "EXAME_ID",nullable = false)
	private ExameEntity exameEntity;
	
	/**
	 * AnswerEntity answerEntity
	 * 
	 * Join Answer Table In ExameDetail Table using answer Id
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ANSWER_ID",nullable = false)
	private AnswerEntity answerEntity;

	
	public ExameDetailsEntity() {
	
	}

	public Integer getExameDetailId() {
		return exameDetailId;
	}

	public void setExameDetailId(Integer exameDetailId) {
		this.exameDetailId = exameDetailId;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}

	public ExameEntity getExameEntity() {
		return exameEntity;
	}

	public void setExameEntity(ExameEntity exameEntity) {
		this.exameEntity = exameEntity;
	}

	public AnswerEntity getAnswerEntity() {
		return answerEntity;
	}

	public void setAnswerEntity(AnswerEntity answerEntity) {
		this.answerEntity = answerEntity;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	
	
	
}
