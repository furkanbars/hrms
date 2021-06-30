package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.EducationSchoolService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.EducationSchoolDao;
import hrms.hrmsProject.entities.concretes.EducationSchool;
import lombok.var;

@Service
public class EducationSchoolManager implements EducationSchoolService{

	private EducationSchoolDao educationSchoolDao;
	
	@Autowired
	public EducationSchoolManager(EducationSchoolDao educationSchoolDao) {
		this.educationSchoolDao=educationSchoolDao;
	}
	
	@Override
	public DataResult<List<EducationSchool>> getAll() {
		var result = this.educationSchoolDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<EducationSchool>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<EducationSchool>>(ProjectMessages.noData);
	}

	@Override
	public Result add(EducationSchool educationSchool) {
		if (this.existSchool(educationSchool.getName())) {
			return new SuccessResult(ProjectMessages.existEducationSchool);
		}
		var result = this.educationSchoolDao.save(educationSchool);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedData);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	private boolean existSchool(String schoolName) {
		var result = this.educationSchoolDao.getByName(schoolName);
		if (result!=null) {
			return true;
		}
		return false;
	}

}
