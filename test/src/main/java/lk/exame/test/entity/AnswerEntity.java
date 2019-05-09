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
@Table(name = "ANSWER")
public class AnswerEntity {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "ANSWER_ID",length = 10)
	  private Integer answerId;
	  
	  @Column(name = "ANSWER",length = 255 , nullable = false)
	  private String ansewer;
	  
	  @Column(name = "CORRECT",length = 1 , nullable = false)
	  private Integer correct;
	  
	  @Column(name = "TAG_NAME",length = 10 )
	  private String tagName;
	  
	  @ManyToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "QUESTION_ID",nullable = false)
	  private QuestionEntity questionEntity;
	  
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
