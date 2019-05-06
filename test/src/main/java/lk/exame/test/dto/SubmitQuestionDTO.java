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
	private String userName;


	
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "SubmitQuestionDTO [questionId=" + questionId + ", userAnswerId=" + userAnswerId + ", userName="
				+ userName + ", getQuestionId()=" + getQuestionId() + ", getUserAnswerId()=" + getUserAnswerId()
				+ ", getUserName()=" + getUserName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
