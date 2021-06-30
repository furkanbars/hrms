package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.EducationGraduateService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.EducationGraduateDao;
import hrms.hrmsProject.entities.concretes.EducationGraduate;
import lombok.var;

@Service
public class EducationGraduateManager implements EducationGraduateService{
	
	private EducationGraduateDao educationGraduateDao;
	
	@Autowired
	public EducationGraduateManager(EducationGraduateDao educationGraduateDao) {
		this.educationGraduateDao=educationGraduateDao;
	}

	@Override
	public DataResult<List<EducationGraduate>> getAll() {
		var result = this.educationGraduateDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<EducationGraduate>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<EducationGraduate>>(ProjectMessages.noData);
	}

	@Override
	public Result add(EducationGraduate educationGraduate) {
		if (this.existEducationGraduate(educationGraduate.getName())) {
			return new ErrorResult(ProjectMessages.existEducationGraduate);
		}
		var result = this.educationGraduateDao.save(educationGraduate);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedData);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	private boolean existEducationGraduate(String graduateName) {
		var result = this.educationGraduateDao.getByName(graduateName);
		if (result!=null) {
			return true;
		}
		return false;
	}
}


