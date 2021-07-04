package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobAdvertisementService;
import hrms.hrmsProject.business.abstracts.JobSeekerJobAdvertisementFavoriteService;
import hrms.hrmsProject.business.abstracts.JobSeekerService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.JobSeekerJobAdvertisementFavoriteDao;
import hrms.hrmsProject.entities.concretes.JobSeekerJobAdvertisementFavorite;
import lombok.var;

@Service
public class JobSeekerJobAdvertisementFavoriteManager implements JobSeekerJobAdvertisementFavoriteService{

	private JobSeekerJobAdvertisementFavoriteDao jobSeekerFavoriteDao;
	private JobSeekerService jobSeekerService;
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobSeekerJobAdvertisementFavoriteManager(JobSeekerJobAdvertisementFavoriteDao jobSeekerFavoriteDao,JobSeekerService jobSeekerService
			,JobAdvertisementService jobAdvertisementService) {
		this.jobSeekerFavoriteDao = jobSeekerFavoriteDao;
		this.jobSeekerService = jobSeekerService;
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@Override
	public Result add(JobSeekerJobAdvertisementFavorite jobAdvertisementFavorite) {
		//var jobSeekerFavorite = new JobSeekerJobAdvertisementFavorite();
		
		//jobSeekerFavorite.setJobSeeker(this.jobSeekerService.getById(jobSeekerFavoriteDto.getJobSeekerId()).getData());
		//jobSeekerFavorite.setJobAdvertisement(this.jobAdvertisementService.getById(jobSeekerFavoriteDto.getJobAdvertisementId()).getData());
		
		var result = this.jobSeekerFavoriteDao.save(jobAdvertisementFavorite);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedFavorite);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public Result delete(int userId,int jobAdvertisementId) {
		this.jobSeekerFavoriteDao.deleteByJobSeekerAndJobAdvertisement(userId,jobAdvertisementId);
		return new SuccessResult(ProjectMessages.deletedFavorite);
	}

	@Override
	public DataResult<List<JobSeekerJobAdvertisementFavorite>> getByJobSeekerId(int jobSeekerId) {
		var result = this.jobSeekerFavoriteDao.getAllByJobSeeker_Id(jobSeekerId);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<JobSeekerJobAdvertisementFavorite>>(result,ProjectMessages.listedFavorite);
		}
		return new ErrorDataResult<List<JobSeekerJobAdvertisementFavorite>>(ProjectMessages.noData);
	}

}
