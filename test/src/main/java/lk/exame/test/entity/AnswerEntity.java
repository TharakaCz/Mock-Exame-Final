
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
@Table(name = "ANSWER")
public class AnswerEntity {

	/**
	 * Integer answerId
	 * 
	 * Generate Answer Id In Answer Table From Database , length 10
	 */
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "ANSWER_ID",length = 10)
	  private Integer answerId;
	  
	  /**
	   * String ansewer
	   * 
	   * Set And Get Answer In Answer Table not null , length 255
	   */
	  @Column(name = "ANSWER",length = 255 , nullable = false)
	  private String ansewer;
	  
	  /**
	   * Integer correct
	   * 
	   * Checking True Answer Result Calculation Time  length 1
	   */
	  @Column(name = "CORRECT",length = 1 , nullable = false)
	  private Integer correct;
	  
	  /**
	   * String tagName
	   * 
	   * Set And Get Answer Tag Name length 10
	   */
	  @Column(name = "TAG_NAME",length = 10 )
	  private String tagName;
	  
	  /**
	   * QuestionEntity questionEntity
	   * 
	   * Join Question Table From Answer Table Using Question Id
	   */
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "QUESTION_ID",nullable = false)
	  private QuestionEntity questionEntity;
	  
	  /**
	   * List<ExameDetailsEntity>exameDetailsEntities
	   * 
	   * mappedBy Answer Table Target By ExameDetail Table
	   */
	  @OneToMany(mappedBy = "answerEntity",targetEntity = ExameDetailsEntity.class)
	  private List<ExameDetailsEntity>exameDetailsEntities;
	  
	  public AnswerEntity() {
	  
	  }
	 
	  public Integer getAnswerId() { return answerId; }
	  
	  public void setAnswerId(Integer answerId) { this.answerId = answerId; }
		  
	  public String getAnsewer() { return ansewer; }
		  
	  public void setAnsewer(String ansewer) { this.ansewer = ansewer; }
		
	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}

	public List<ExameDetailsEntity> getExameDetailsEntities() {
		return exameDetailsEntities;
	}

	public void setExameDetailsEntities(List<ExameDetailsEntity> exameDetailsEntities) {
		this.exameDetailsEntities = exameDetailsEntities;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public QuestionEntity getQuestionEntity() { return questionEntity; }
	  
	  public void setQuestionEntity(QuestionEntity questionEntity) {
	  this.questionEntity = questionEntity; }
	  
	  @Override public String toString() { return "AnswerEntity [answerId=" +
	  answerId + ", ansewer=" + ansewer + 
	  ", questionEntity=" + questionEntity + "]"; }
	 

	
	
	
}
