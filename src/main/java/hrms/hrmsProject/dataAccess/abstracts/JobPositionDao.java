package hrms.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsProject.entities.concretes.Job;

public interface JobPositionDao extends JpaRepository<Job, Integer>{
	Job findByName(String name);
}
