package lk.exame.test.dto;

/**
 * 
 * @author Tharaka Chandralal
 */
public class SubjectDTO {

	private Integer subId;
	
	private String subName;

	
	public SubjectDTO() {
		
	}
	
	public SubjectDTO(Integer subId) {
		this.subId = subId;
	}
	
	public SubjectDTO(String subName) {
		this.subName = subName;
	}

	public SubjectDTO(Integer subId, String subName) {
		this.subId = subId;
		this.subName = subName;
	}


	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	


	@Override
	public String toString() {
		return "SubjectDTO [subId=" + subId + ", subName=" + subName + "]";
	}

	
	
}
