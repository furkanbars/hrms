package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);
	DataResult<List<Experience>> getAll();
}
