/**
 * May 6, 2019	
 * test
 * lk.exame.test.dto
 */
package lk.exame.test.dto;

/**
 * @author Tharaka Chandralal
 */
public class SubmitQuestionDTO {

	private Integer questionId;
	private Integer userAnswerId;


	public SubmitQuestionDTO() {
		
	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getUserAnswerId() {
		return userAnswerId;
	}
	public void setUserAnswerId(Integer userAnswerId) {
		this.userAnswerId = userAnswerId;
	}
	
	
}
