package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Technology;

public interface TechnologyService {
	Result add(Technology technology);
	DataResult<List<Technology>> getAll();
}
