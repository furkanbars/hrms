package hrms.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.EducationFacultyService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.EducationFacultyDao;
import hrms.hrmsProject.entities.concretes.EducationFaculty;
import lombok.var;

@Service
public class EducationFacultyManager implements EducationFacultyService{
	
	private EducationFacultyDao educationFacultyDao;
	
	@Autowired
	public EducationFacultyManager(EducationFacultyDao educationFacultyDao) {
		this.educationFacultyDao=educationFacultyDao;
	}
	
	
	@Override
	public DataResult<EducationFaculty> getBySchoolId(int schoolId) {
		var result = this.educationFacultyDao.getBySchool_Id(schoolId);
		if (result!=null) {
			return new SuccessDataResult<EducationFaculty>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<EducationFaculty>(ProjectMessages.noData);
	}

	@Override
	public Result add(EducationFaculty educationFaculty) {
		if (this.existEducationFaculty(educationFaculty.getName())) {
			return new ErrorResult(ProjectMessages.existEducationFaculty);
		}
		var result = this.educationFacultyDao.save(educationFaculty);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedFaculty);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	private boolean existEducationFaculty(String facultyName) {
		var result = this.educationFacultyDao.getByName(facultyName);
		if (result!=null) {
			return true;
		}
		return false;
	}

}




