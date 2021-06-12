package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.JobAdvertisement;
import hrms.hrmsProject.entities.concretes.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisementDto jobAdvertisementDto);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllByIsActive();
	DataResult<List<JobAdvertisement>> getAllByIsActiveAndLastDateAsc();
	DataResult<List<JobAdvertisement>> getAllByEmployerId(int userId);
}
