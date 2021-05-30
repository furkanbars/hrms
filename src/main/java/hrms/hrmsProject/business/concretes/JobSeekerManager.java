package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobSeekerService;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.JobSeekerDao;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import lombok.var;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		this.jobSeekerDao=jobSeekerDao;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll()); 
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Kullanıcı başarıyla eklendi.");
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
		var result=jobSeekerDao.getByIdentityNumber(identityNumber);
		if (result!=null) {
			return new SuccessDataResult<JobSeeker>(result);
		}
		return new ErrorDataResult<JobSeeker>("Bu TC'ye sahip veri bulunamadı!");
	}


}
