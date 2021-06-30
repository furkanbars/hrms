package hrms.hrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	List<Experience> getByCv_id(int id);
}
