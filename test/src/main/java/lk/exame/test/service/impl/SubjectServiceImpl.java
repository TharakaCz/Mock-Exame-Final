package lk.exame.test.service.impl;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.QuestionDAO;
import lk.exame.test.dao.SubjectDAO;
import lk.exame.test.dto.SubjectDTO;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.SubjectEntity;
import lk.exame.test.service.SubjectService;
import lk.exame.test.utill.AppConstant;

/**
 * 
 * @author Tharaka Chandralal
 */
@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired 
	private SubjectDAO subjectDao;
	
	@Autowired
	private QuestionDAO questionDao;

	/**
	 * Deceive Active Row In Subject Table
	 */
	@Override
	public boolean delete(Integer subId) throws Exception {
		
		SubjectEntity subjectEntity = subjectDao.findBySubId(subId);
		
		QuestionEntity questionEntity = questionDao.findOneBySubjectEntitiy(subjectEntity);
		
		subjectEntity.setStatus(AppConstant.DEACTIVE);
		questionEntity.setStatus(AppConstant.DEACTIVE);
		if (subjectEntity != null) {
			
			subjectDao.save(subjectEntity);
			questionDao.save(questionEntity);
		}else {
			System.out.println("Subject Table Empty");
		}
		return true;
	}

	/**
	 * Find Subject In Subject Table Using Subject Id
	 */
	@Override
	public SubjectDTO findSubject(Integer subId) throws Exception {
		
		SubjectEntity subject = subjectDao.findBySubId(subId);
		
		SubjectDTO subjectDTO = new SubjectDTO();
		String decodeSubject = URLDecoder.decode(subject.getSubName(),"UTF-8");
		
		subjectDTO.setSubId(subject.getSubId());
		subjectDTO.setSubName(decodeSubject);
		return subjectDTO;
	}

	/**
	 * This Method Using getAllSubject in Subject Table 
	 */
	@Override
	public ArrayList<SubjectDTO> getAllSubject() throws Exception {

		String status = AppConstant.ACTIVE;
		List<SubjectEntity>subjects = subjectDao.findAllByStatus(status);
	
		ArrayList<SubjectDTO>subjectDTOs = new ArrayList<>();
		
		subjects.forEach(e->{
			try {
				subjectDTOs.add(getAllSubject(e));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
			return subjectDTOs;
	
	}

	/* (non-Javadoc)
	 * 
	 * This Method Using Save Subject In Subject Table 
	 * 
	 * @see lk.exame.test.service.SubjectService#save(lk.exame.test.dto.SubjectDTO)
	 */
	@Override
	public boolean save(SubjectDTO subjectDTO) throws Exception {
		 SubjectEntity subjectEntity = new SubjectEntity();
		 
		 subjectEntity.setSubName(subjectDTO.getSubName());
		 subjectEntity.setStatus(AppConstant.ACTIVE);
		 subjectDao.save(subjectEntity);
		 
		return true;
	}

	private SubjectDTO getAllSubject(SubjectEntity subjectEntity) throws Exception{
		
		SubjectDTO subjectDTO = new SubjectDTO();
		
		String decodeSubject = URLDecoder.decode(subjectEntity.getSubName(),"UTF-8");
		
		subjectDTO.setSubId(subjectEntity.getSubId());
		subjectDTO.setSubName(decodeSubject);
		
		return subjectDTO;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.SubjectService#edit(lk.exame.test.dto.SubjectDTO)
	 */
	@Override
	public boolean edit(SubjectDTO subjectDTO) throws Exception {
		
		SubjectEntity subjectEntity = subjectDao.findBySubId(subjectDTO.getSubId());
		
		String subjectEncode = URLEncoder.encode(subjectEntity.getSubName(),"UTF-8");
		subjectEntity.setSubName(subjectEncode);
		
		subjectDao.save(subjectEntity);
		
		return false;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.SubjectService#getAllDeactiveSubjects()
	 */
	@Override
	public ArrayList<SubjectDTO> getAllDeactiveSubjects() throws Exception {
		
		List<SubjectEntity>subjectEntities = subjectDao.findAllByStatus(AppConstant.DEACTIVE);
		ArrayList<SubjectDTO>subjectDTOs = new ArrayList<SubjectDTO>();
		
		subjectEntities.forEach(each->{
			try {
				subjectDTOs.add(getAllSubject(each));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return subjectDTOs;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.SubjectService#activeDeactiveSubject(java.lang.Integer)
	 */
	@Override
	public String activeDeactiveSubject(Integer subjectId) throws Exception {
		
		SubjectEntity subjectEntity = subjectDao.findBySubId(subjectId);
		QuestionEntity questionEntity = questionDao.findOneBySubjectEntitiy(subjectEntity);
		
		String status = AppConstant.ACTIVE;
		subjectEntity.setStatus(status);
		questionEntity.setStatus(status);
		if (subjectEntity != null) {
			subjectDao.save(subjectEntity);
			questionDao.save(questionEntity);
			
			return "Subject Activation Succsessfull . . !";
		}else {
			return "Subject Activetion Faild Please Try Again . .!";
		}
		
	}
}
