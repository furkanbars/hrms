package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>>  getAll();
	Result add(Employer employer);
}
