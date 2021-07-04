package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobAdvertisementService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import hrms.hrmsProject.entities.concretes.JobAdvertisement;
import hrms.hrmsProject.entities.concretes.dtos.JobAdvertisementAddDto;
import lombok.var;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao=jobAdvertisementDao;
	}
	
	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		
		var jobAdvertisement = setAdvertisement(jobAdvertisementAddDto);
		
		var result = this.jobAdvertisementDao.save(jobAdvertisement);
		
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedJobAdvertisement);
		}
		
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		var result=jobAdvertisementDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,ProjectMessages.listedAllJobAdvertisements);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.notFoundAllJobAdvertisement);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActive() {
		var result=jobAdvertisementDao.getAllByIsActive();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,ProjectMessages.listedActiveJobAdvertisement);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.notFoundActiveJobAdvertisement);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveAndLastDateAsc() {
		var result=this.jobAdvertisementDao.getAllByIsActiveAndLastDateAsc();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,ProjectMessages.listedByLastDate);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.noData);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(int userId) {
		var result=this.jobAdvertisementDao.getByEmployer_Id(userId);
		if (result!=null) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,ProjectMessages.listedJobAdvertisementByEmployer);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.notFoundJobAdvertisement);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllNotConfirmed() {
		var result=this.jobAdvertisementDao.getAllNotConfirmed();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<JobAdvertisement>>(result);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		var result=this.jobAdvertisementDao.getById(id);
		if (result!=null) {
			return new SuccessDataResult<JobAdvertisement>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<JobAdvertisement>(ProjectMessages.noData);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveAndIsConfirmAndLastDateAsc() {
		var result = this.jobAdvertisementDao.getAllByIsActiveAndIsConfirmAndLastDateAsc();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,ProjectMessages.listedActiveConfirmLastDateJobAdvertisement);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.noData);
	}
	
	
	@Override
	public Result updateIsActive(int id) {
		this.jobAdvertisementDao.updateIsActive(id);
		return new SuccessResult(ProjectMessages.updatedIsActiveFalse);
	}
	
	@Override
	public Result updateConfirmStatus(int id) {
			this.jobAdvertisementDao.updateConfirmStatus(id);
			return new SuccessResult(ProjectMessages.updatedJobAdvertisementStatus);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize,Sort.by(Sort.Direction.DESC,"lastDate"));
		var result = this.jobAdvertisementDao.findByIsActiveTrueAndIsConfirmTrue(pageable);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,ProjectMessages.listedJobAdvertisementWithPageable);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.errorResultMessage);
	}
	
	private JobAdvertisement setAdvertisement(JobAdvertisementAddDto jobAdvertisementAddDto) {
		JobAdvertisement jobAdvertisement=new JobAdvertisement(jobAdvertisementAddDto.getEmployerId(),jobAdvertisementAddDto.getJobId(),
				jobAdvertisementAddDto.getCityId(),jobAdvertisementAddDto.getTitle(),jobAdvertisementAddDto.getDescription(),jobAdvertisementAddDto.getMinSalary(),jobAdvertisementAddDto.getMaxSalary(),
				jobAdvertisementAddDto.getWorkingTypeId(),jobAdvertisementAddDto.getWorkingHourId(),jobAdvertisementAddDto.getNumberOfPosition(),
				jobAdvertisementAddDto.getLastDate(),jobAdvertisementAddDto.isActive(),jobAdvertisementAddDto.isConfirm());
		return jobAdvertisement;
	}



}
