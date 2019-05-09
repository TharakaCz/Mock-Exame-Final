/**
 * May 8, 2019	
 * test
 * lk.exame.test.dao.impl
 */
package lk.exame.test.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import lk.exame.test.dao.custom.QuestionDaoCustom;
import lk.exame.test.entity.QuestionEntity;

/**
 * @author Tharaka Chandralal
 */
@Repository
public class QuestionDaoImpl implements QuestionDaoCustom {

	@PersistenceContext
	EntityManager entitiManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * lk.exame.test.dao.custom.QuestionDaoCustom#getPrimaryStage(java.lang.Integer)
	 */
	/*
	 * @Override public List<QuestionEntity> getPrimaryStage(String
	 * questionLeval,String status,Integer languageId){
	 * 
	 * String sql =
	 * " SELECT * FROM question where question_leval =? and status=? and language_id =? order by rand() limit 1"
	 * ; Query query = entitiManager.createNativeQuery(sql,QuestionEntity.class);
	 * query.setParameter(1, questionLeval); query.setParameter(2, status);
	 * query.setParameter(3, languageId);
	 * 
	 * return query.getResultList(); } (non-Javadoc)
	 * 
	 * @see
	 * lk.exame.test.dao.custom.QuestionDaoCustom#getEasyStage(java.lang.String,
	 * java.lang.String, java.lang.Integer, java.util.List)
	 * 
	 * @Override public QuestionEntity getSeconderyStage(String questionLeval,
	 * String status, Integer languageId,List<Integer> questionIds) {
	 * 
	 * String ids ="" ;
	 * 
	 * for (Integer val : questionIds) { ids+="'"+val.toString()+"',"; } ids =
	 * ids.replaceAll(",$", "");
	 * 
	 * System.out.println("IDS = = = /"+ids.toString()); String sql =
	 * "SELECT * FROM question where question_leval =? and status=? and language_id =? and ques_id NOT IN("
	 * +ids+") order by rand() limit 1"; Query query =
	 * entitiManager.createNativeQuery(sql,QuestionEntity.class);
	 * 
	 * 
	 * query.setParameter(1, questionLeval); query.setParameter(2, status);
	 * query.setParameter(3, languageId); query.setParameter(4, quesNum);
	 * 
	 * return (QuestionEntity) query.getSingleResult(); } (non-Javadoc)
	 * 
	 * @see lk.exame.test.dao.custom.QuestionDaoCustom#getQuestion(java.lang.String,
	 * java.lang.String, java.lang.Integer, java.lang.String)
	 */
	@Override
	public QuestionEntity getQuestion(String questionLeval, String status, Integer languageId, String sqlCombinetion) {

		String sql = "SELECT * FROM question where question_leval =? and status=? and language_id =? " + sqlCombinetion+ "  order by rand() limit 1";
		Query query = entitiManager.createNativeQuery(sql, QuestionEntity.class);

		query.setParameter(1, questionLeval);
		query.setParameter(2, status);
		query.setParameter(3, languageId);

		return (QuestionEntity) query.getSingleResult();
	}

}
