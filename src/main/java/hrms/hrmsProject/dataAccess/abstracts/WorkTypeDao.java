package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{
	
}
