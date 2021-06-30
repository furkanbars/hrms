package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.EducationSchool;

public interface EducationSchoolService {
	DataResult<List<EducationSchool>> getAll();
	Result add(EducationSchool educationSchool);
}
