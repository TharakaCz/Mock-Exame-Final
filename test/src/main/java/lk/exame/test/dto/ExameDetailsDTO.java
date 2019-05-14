package lk.exame.test.dto;


public class ExameDetailsDTO {

	private Integer exameDetailId;
	
	private String level;
	
	private String enable;
	
	private QuestionsDTO questionsDTO;
	
	private ExameDTO exameDTO;
	
	private AnswersDTO answersDTO;
	
	private ResultDTO resultDTO;

	public ExameDetailsDTO() {
		
	}

	public Integer getExameDetailId() {
		return exameDetailId;
	}

	public void setExameDetailId(Integer exameDetailId) {
		this.exameDetailId = exameDetailId;
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

	public ExameDTO getExameDTO() {
		return exameDTO;
	}

	public void setExameDTO(ExameDTO exameDTO) {
		this.exameDTO = exameDTO;
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
