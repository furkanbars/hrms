package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.CvTechnology;

public interface CvTechnologyDao extends JpaRepository<CvTechnology, Integer>{
	CvTechnology getByCv_id(int id);
}
