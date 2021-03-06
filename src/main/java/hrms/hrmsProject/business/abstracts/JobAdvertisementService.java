package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.JobAdvertisement;
import hrms.hrmsProject.entities.concretes.dtos.JobAdvertisementAddDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllByIsActive();
	DataResult<List<JobAdvertisement>> getAllByIsActiveAndLastDateAsc();
	DataResult<List<JobAdvertisement>> getAllByIsActiveAndIsConfirmAndLastDateAsc();
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>> getAllByEmployerId(int userId);
	DataResult<List<JobAdvertisement>> getAllNotConfirmed();
	Result updateConfirmStatus(int id);
	Result updateIsActive(int id);
	DataResult<List<JobAdvertisement>> getAllSorted(int pageNo,int pageSize);
}
