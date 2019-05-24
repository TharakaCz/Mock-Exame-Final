
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
	  private Integer answerId;
	  
	  
	  /**
	   * String ansewer
	   * 
	   * Set And Get Answer In Answer Table not null , length 255
	   */
	 
	  private String ansewer;
	  
	  /**
	   * Integer correct
	   * 
	   * Checking True Answer Result Calculation Time  length 1
	   */
	  private Integer correct;
	  
	  /**
	   * String tagName
	   * 
	   * Set And Get Answer Tag Name length 10
	   */
	  
	  private String tagName;
	  
	  /**
	   * QuestionEntity questionEntity
	   * 
	   * Join Question Table From Answer Table Using Question Id
	   */
	  private QuestionEntity questionEntity;
	  
	  /**
	   * List<ExameDetailsEntity>exameDetailsEntities
		* 
		* mappedBy Answer Table Target By ExameDetail Table
	 */
	  private List<ExamDetailsEntity> examDetailsEntities;
	  
	  
	  private String status;
	  
	  public AnswerEntity() {
	  
	  }

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name = "ANSWER_ID",length = 10,nullable=false)
	public Integer getAnswerId() {
		return answerId;
	}

	
	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	@Column(name = "ANSWER",length = 255 , nullable = false)
	public String getAnsewer() {
		return ansewer;
	}

	public void setAnsewer(String ansewer) {
		this.ansewer = ansewer;
	}

	@Column(name = "CORRECT",length = 1 , nullable = false)
	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}

	@Column(name = "TAG_NAME",length = 10 )
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTION_ID",nullable = false)
	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}

	@OneToMany(mappedBy = "answerEntity",targetEntity = ExamDetailsEntity.class)
	public List<ExamDetailsEntity> getExameDetailsEntities() {
		return examDetailsEntities;
	}

	public void setExameDetailsEntities(List<ExamDetailsEntity> examDetailsEntities) {
		this.examDetailsEntities = examDetailsEntities;
	}


	@Column(name="STATUS",length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	  
	 
	
}
