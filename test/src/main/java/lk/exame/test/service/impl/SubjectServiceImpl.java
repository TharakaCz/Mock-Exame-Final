package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dao.SubjectDAO;
import lk.exame.test.dto.SubjectDTO;
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
	

	/**
	 * Deceive Active Row In Subject Table
	 */
	@Override
	public boolean delete(Integer subId) throws Exception {
		
		SubjectEntity subjectEntity = subjectDao.findById(subId).get();
		
		subjectEntity.setStatus(AppConstant.DEACTIVE);
		
		if (subjectEntity != null) {
			
			subjectDao.save(subjectEntity);
			
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
		
		SubjectEntity subject = subjectDao.findById(subId).get();
		
		SubjectDTO subjectDTO = new SubjectDTO(
				subject.getSubId(),
				subject.getSubName()
				);
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
			subjectDTOs.add(getAllSubject(e));
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

	private SubjectDTO getAllSubject(SubjectEntity subjectEntity) {
		
		SubjectDTO subjectDTO = new SubjectDTO();
		
		subjectDTO.setSubId(subjectEntity.getSubId());
		subjectDTO.setSubName(subjectEntity.getSubName());
		
		return subjectDTO;
	}
}
