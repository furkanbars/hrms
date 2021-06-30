package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Cv;

public interface CvService {
	Result add(Cv cv);
	DataResult<List<Cv>> getAll();
	DataResult<Cv> getById(int id);
	DataResult<Cv> getByJobSeekerId(int userId);
}
