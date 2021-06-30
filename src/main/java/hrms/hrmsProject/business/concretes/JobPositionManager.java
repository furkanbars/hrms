package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.JobPositionDao;
import hrms.hrmsProject.entities.concretes.Job;
import lombok.var;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao=jobPositionDao;
	}
	
	@Override
	public DataResult<List<Job>> GetAll() {
		var result = this.jobPositionDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Job>>(result,ProjectMessages.successResultMessage); 
		}
		return new ErrorDataResult<List<Job>>(ProjectMessages.noData);
	}

	@Override
	public Result Add(Job job) {
		
		if (existJobPosition(job.getName())) {
			return new ErrorResult(ProjectMessages.existJobPosition);
		}
		
		var result = this.jobPositionDao.save(job);
		
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedJobPosition);
		}
		
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	private boolean existJobPosition(String jobPositionName) {
		var result = this.jobPositionDao.getByName(jobPositionName);
		if (result!=null){
			return true;
		}
		return false;
	}

}
