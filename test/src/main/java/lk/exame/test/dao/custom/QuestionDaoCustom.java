/**
 * May 8, 2019	
 * test
 * lk.exame.test.dao.custom
 */
package lk.exame.test.dao.custom;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import lk.exame.test.entity.QuestionEntity;

/**
 * @author Tharaka Chandralal
 */
public interface QuestionDaoCustom {

	/*
	 * List<QuestionEntity> getPrimaryStage(String questionLeval,String
	 * status,Integer languageId);
	 * 
	 * QuestionEntity getSeconderyStage(String questionLeval,String status,Integer
	 * languageId,List<Integer> questionIds);
	 */

	/**
	 * @param questionLeval
	 * @param status
	 * @param languageId
	 * @param sql
	 */
	QuestionEntity getQuestion(String questionLeval, String status, Integer languageId, String sql);
	
}
