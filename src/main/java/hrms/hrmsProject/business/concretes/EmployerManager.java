package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.EmployerService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.EmployerDao;
import hrms.hrmsProject.entities.concretes.Employer;
import lombok.var;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao=employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		var result=employerDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Employer>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<Employer>>(ProjectMessages.noData);
	}


	@Override
	public Result add(Employer employer) {
		var result = this.employerDao.save(employer);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedEmployer);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

}
