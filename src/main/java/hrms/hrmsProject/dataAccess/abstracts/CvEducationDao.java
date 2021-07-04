package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.CvEducation;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer>{
	List<CvEducation> getByCv_id(int id);
	CvEducation getById(int id);
}
