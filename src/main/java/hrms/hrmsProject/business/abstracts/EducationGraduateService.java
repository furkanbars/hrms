package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.EducationGraduate;

public interface EducationGraduateService {
	DataResult<List<EducationGraduate>> getAll();
	Result add(EducationGraduate educationGraduate);
}
