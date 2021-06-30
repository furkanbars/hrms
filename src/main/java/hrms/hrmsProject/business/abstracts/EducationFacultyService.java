package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.EducationFaculty;

public interface EducationFacultyService {
	DataResult<EducationFaculty> getBySchoolId(int schoolId);
	Result add(EducationFaculty educationFaculty);
	
}
