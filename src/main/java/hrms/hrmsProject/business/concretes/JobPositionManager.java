package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.JobPositionDao;
import hrms.hrmsProject.entities.concretes.Job;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao=jobPositionDao;
	}
	
	@Override
	public DataResult<List<Job>> GetAll() {
		return new SuccessDataResult<List<Job>>(this.jobPositionDao.findAll()); 
	}

	@Override
	public Result Add(Job job) {
		if (this.jobPositionDao.findByName(job.getName())!=null){
			return new ErrorResult("Exist already job position");
		}
		this.jobPositionDao.save(job);
		return new SuccessResult("Eklendi!");
	}

}
