package lk.exame.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.exame.test.dto.SubjectDTO;
import lk.exame.test.entity.QuestionEntity;
import lk.exame.test.entity.SubjectEntity;
import lk.exame.test.repository.QuestionRepository;
import lk.exame.test.repository.SubjectRepository;
import lk.exame.test.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired 
	private SubjectRepository subjectRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	/*
	 * @Override public boolean save(SubjectDTO subjectDTO) throws Exception {
	 * 
	 * subRepository.save(getSubjectEntity(subjectDTO));
	 * 
	 * return true; }
	 */
	
	/*
	 * private SubjectEntity getSubjectEntity(SubjectDTO subjectDTO)throws
	 * Exception{
	 * 
	 * QuestionEntity
	 * questionEntity=questionRepository.getOne(subjectDTO.getQuestionId());
	 * 
	 * 
	 * System.out.println("call"); SubjectEntity subjectEntity = new
	 * SubjectEntity(); subjectEntity.setSubName(subjectDTO.getSubName());
	 * subjectEntity.setQuestionEntity(questionEntity);
	 * 
	 * return subjectEntity; }
	 */

	@Override
	public boolean delete(Integer subId) throws Exception {
		
		subjectRepository.deleteById(subId);
		return true;
	}

	@Override
	public SubjectDTO findSubject(Integer subId) throws Exception {
		
		SubjectEntity subject = subjectRepository.findById(subId).get();
		
		SubjectDTO subjectDTO = new SubjectDTO(
				subject.getSubId(),
				subject.getSubName()
				);
		return subjectDTO;
	}

	@Override
	public ArrayList<SubjectDTO> getAllSubject() throws Exception {

		List<SubjectEntity>subjects = subjectRepository.findAll();
		
		ArrayList<SubjectDTO>subjectDTOs = new ArrayList<>();
		
		subjects.forEach(e->{
			subjectDTOs.add(getAllSubject(e));
		});
		
		return subjectDTOs;
	}

	/* (non-Javadoc)
	 * @see lk.exame.test.service.SubjectService#save(lk.exame.test.dto.SubjectDTO)
	 */
	@Override
	public boolean save(SubjectDTO subjectDTO) throws Exception {
		 SubjectEntity subjectEntity = new SubjectEntity();
		 
		 subjectEntity.setSubName(subjectDTO.getSubName());
		 
		 subjectRepository.save(subjectEntity);
		 
		return true;
	}

	private SubjectDTO getAllSubject(SubjectEntity subjectEntity) {
		
		SubjectDTO subjectDTO = new SubjectDTO();
		
		subjectDTO.setSubId(subjectEntity.getSubId());
		subjectDTO.setSubName(subjectEntity.getSubName());
		
		return subjectDTO;
	}
}
