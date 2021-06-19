package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.WorkHour;

public interface WorkHourDao extends JpaRepository<WorkHour, Integer>{
	
}
