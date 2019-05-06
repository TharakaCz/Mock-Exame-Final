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
@Table(name="LANGUAGE")
public class LanguageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LANGUAGE_ID",length = 10)
	private Integer langId;
	
	@Column(name = "LANGUAGE_NAME",nullable=false,length = 50)
	private String langName;

	@OneToMany(mappedBy="languageEntity",targetEntity=ExameEntity.class)
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
