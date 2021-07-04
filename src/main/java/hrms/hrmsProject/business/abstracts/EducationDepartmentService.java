package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.entities.concretes.EducationDepartment;

public interface EducationDepartmentService {
	DataResult<List<EducationDepartment>> getAllBySchoolId(int schoolId);
}
