/**
 * May 27, 2019	
 * test
 * lk.exame.test.dto
 */
package lk.exame.test.dto;

import java.util.List;

/**
 * @author Tharaka Chandralal
 */
public class ExamBasicDetailDTO {

	private Integer exameQuestionLimit;
	
	private Integer exameTimeCout;

	private List<Integer>examQuestionMarks;
	
	public ExamBasicDetailDTO() {
		
	}

	public Integer getExameQuestionLimit() {
		return exameQuestionLimit;
	}

	public void setExameQuestionLimit(Integer exameQuestionLimit) {
		this.exameQuestionLimit = exameQuestionLimit;
	}

	public Integer getExameTimeCout() {
		return exameTimeCout;
	}

	public void setExameTimeCout(Integer exameTimeCout) {
		this.exameTimeCout = exameTimeCout;
	}

	public List<Integer> getExamQuestionMarks() {
		return examQuestionMarks;
	}

	public void setExamQuestionMarks(List<Integer> examQuestionMarks) {
		this.examQuestionMarks = examQuestionMarks;
	}

	
	
}
