package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	List<Education> getByCv_id(int id);
}
