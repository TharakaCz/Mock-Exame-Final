/**
 * May 2, 2019	
 * test
 * lk.exame.test.dto
 */
package lk.exame.test.dto;

import java.util.List;

/**
 * @author Tharaka Chandralal
 */
public class ReqDTO {

	private Integer exameId; 
	private List<Integer> questionIds;
	
	public ReqDTO() {
		
	}

	public Integer getExameId() {
		return exameId;
	}

	public void setExameId(Integer exameId) {
		this.exameId = exameId;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}

	@Override
	public String toString() {
		return "ReqDTO [exameId=" + exameId + ", questionIds=" + questionIds + "]";
	}

	
	
	
}
