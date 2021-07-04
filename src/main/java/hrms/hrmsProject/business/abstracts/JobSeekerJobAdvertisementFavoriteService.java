package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.JobSeekerJobAdvertisementFavorite;
import hrms.hrmsProject.entities.concretes.dtos.JobSeekerFavoriteDto;

public interface JobSeekerJobAdvertisementFavoriteService {
	Result add(JobSeekerJobAdvertisementFavorite jobAdvertisementFavorite);
	Result delete(int userId,int jobAdvertisementId);
	DataResult<List<JobSeekerJobAdvertisementFavorite>> getByJobSeekerId(int jobSeekerId);
}
