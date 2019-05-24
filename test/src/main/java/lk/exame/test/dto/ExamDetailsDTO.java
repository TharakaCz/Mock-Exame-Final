package lk.exame.test.dto;

/**
 * 
 * @author Tharaka Chandralal
 */
public class ExamDetailsDTO {

	private Integer examDetailId;
	
	private String level;
	
	private String enable;
	
	private QuestionsDTO questionsDTO;
	
	private ExamDTO examDTO;
	
	private AnswersDTO answersDTO;
	
	private ResultDTO resultDTO;

	public ExamDetailsDTO() {
		
	}

	public Integer getExamDetailId() {
		return examDetailId;
	}

	public void setExameDetailId(Integer examDetailId) {
		this.examDetailId = examDetailId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public QuestionsDTO getQuestionsDTO() {
		return questionsDTO;
	}

	public void setQuestionsDTO(QuestionsDTO questionsDTO) {
		this.questionsDTO = questionsDTO;
	}

	public ExamDTO getExameDTO() {
		return examDTO;
	}

	public void setExameDTO(ExamDTO examDTO) {
		this.examDTO = examDTO;
	}

	public AnswersDTO getAnswersDTO() {
		return answersDTO;
	}

	public void setAnswersDTO(AnswersDTO answersDTO) {
		this.answersDTO = answersDTO;
	}

	public ResultDTO getResultDTO() {
		return resultDTO;
	}

	public void setResultDTO(ResultDTO resultDTO) {
		this.resultDTO = resultDTO;
	}

	
	
	
}
