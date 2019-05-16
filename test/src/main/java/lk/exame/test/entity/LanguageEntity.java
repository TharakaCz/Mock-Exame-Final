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
@Table(name="LANGUAGE")
public class LanguageEntity {

	/**
	 * Integer langId
	 * 
	 * Generate LanguageId In Language Table From Database , length 10
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LANGUAGE_ID",length = 10)
	private Integer langId;
	
	/**
	 * String langName
	 * 
	 * Set And Get Language Name Not Null , length 50
	 */
	@Column(name = "LANGUAGE_NAME",nullable=false,length = 50)
	private String langName;

	/**
	 * List<QuestionEntity>questionEntities
	 * 
	 * mappedBy Language Table Target by Question Table 
	 */
	@OneToMany(mappedBy="languageEntitiey",targetEntity=QuestionEntity.class)
	private List<QuestionEntity>questionEntities ;


	public LanguageEntity() {
		
	}

	public LanguageEntity(String langName) {
		this.langName = langName;
	}

	public Integer getLangId() {
		return langId;
	}

	public void setLangId(Integer langId) {
		this.langId = langId;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}
	
	
	public List<QuestionEntity> getQuestionEntities() {
		return questionEntities;
	}

	public void setQuestionEntities(List<QuestionEntity> questionEntities) {
		this.questionEntities = questionEntities;
	}

	@Override
	public String toString() {
		return "LanguageEntity [langId=" + langId + ", langName=" + langName + "]";
	}
	
	
	
}
