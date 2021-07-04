package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.EducationDepartmentService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.EducationDepartmentDao;
import hrms.hrmsProject.entities.concretes.EducationDepartment;
import lombok.var;

@Service
public class EducationDepartmentManager implements EducationDepartmentService{
	
	private EducationDepartmentDao educationDepartmentDao;
	
	@Autowired
	public EducationDepartmentManager(EducationDepartmentDao educationDepartmentDao) {
		this.educationDepartmentDao=educationDepartmentDao;
	}
	
	@Override
	public DataResult<List<EducationDepartment>> getAllBySchoolId(int schoolId) {
		var result = this.educationDepartmentDao.getAllBySchoolId(schoolId);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<EducationDepartment>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<EducationDepartment>>(ProjectMessages.errorResultMessage);
	}

}
