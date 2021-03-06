package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Job;

public interface JobPositionService {
	DataResult<List<Job>> GetAll();
	Result Add(Job job);
}
