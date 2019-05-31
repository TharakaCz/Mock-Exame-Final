package lk.exame.test.dto;

/**
 * 
 * @author Tharaka Chandralal
 */
public class LanguageDTO {

	private Integer langId;
	private String langName;
	
	
	
	public LanguageDTO() {
		
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

	@Override
	public String toString() {
		return "LanguageDTO [langId=" + langId + ", langName=" + langName + "]";
	}
	
	
}
