package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer>{
	List<CvExperience> getByCv_id(int id);
}
