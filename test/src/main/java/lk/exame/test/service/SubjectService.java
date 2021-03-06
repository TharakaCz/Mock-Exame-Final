package lk.exame.test.service;

import java.util.ArrayList;

import lk.exame.test.dto.SubjectDTO;

/**
 * 
 * @author Tharaka Chandralal
 */
public interface SubjectService {

	public boolean save(SubjectDTO subjectDTO)throws Exception;
	
	public boolean delete(Integer subId)throws Exception;
	
	public SubjectDTO findSubject(Integer subId)throws Exception;
	
	public boolean edit(SubjectDTO subjectDTO)throws Exception;
	
	public ArrayList<SubjectDTO>getAllSubject()throws Exception;
	
	public ArrayList<SubjectDTO>getAllDeactiveSubjects()throws Exception;
	
	public String activeDeactiveSubject(Integer subjectId)throws Exception;
}
