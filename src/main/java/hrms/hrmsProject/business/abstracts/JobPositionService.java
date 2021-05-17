package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.entities.concretes.Job;

public interface JobPositionService {
	List<Job> GetAll();
}
