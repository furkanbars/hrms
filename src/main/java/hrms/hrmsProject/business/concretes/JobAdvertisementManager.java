package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobAdvertisementService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
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
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(ProjectMessages.addedJobAdvertisement);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		var result=jobAdvertisementDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,"İş pozisyonları listelendi.");
		}
		return new ErrorDataResult<List<JobAdvertisement>>("İş pozisyonu bulunamadı!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActive() {
		var result=jobAdvertisementDao.getAllByIsActive();
		if (result!=null) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,"Aktif iş ilanları listelendi.");
		}
		return new ErrorDataResult<List<JobAdvertisement>>("Aktif iş ilanı bulunamadı!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByIsActiveAndLastDateAsc() {
		var result=this.jobAdvertisementDao.getAllByIsActiveAndLastDateAsc();
		if (result!=null) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,"İş ilanları son tarihine göre listelendi.");
		}
		return new ErrorDataResult<List<JobAdvertisement>>("İş ilanı bulunamadı!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(int userId) {
		var result=this.jobAdvertisementDao.getByEmployer_Id(userId);
		if (result!=null) {
			return new SuccessDataResult<List<JobAdvertisement>>(result,"Firmaya ait iş ilanları listelendi.");
		}
		return new ErrorDataResult<List<JobAdvertisement>>("Firmaya ait iş ilanı bulunamadı!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllNotConfirmed() {
		var result=this.jobAdvertisementDao.getAllNotConfirmed();
		if (result!=null) {
			return new SuccessDataResult<List<JobAdvertisement>>(result);
		}
		return new ErrorDataResult<List<JobAdvertisement>>(ProjectMessages.noData);
	}
	
	private JobAdvertisement setAdvertisement(JobAdvertisementAddDto jobAdvertisementAddDto) {
		JobAdvertisement jobAdvertisement=new JobAdvertisement(jobAdvertisementAddDto.getEmployerId(),jobAdvertisementAddDto.getJobId(),
				jobAdvertisementAddDto.getCityId(),jobAdvertisementAddDto.getDescription(),jobAdvertisementAddDto.getMinSalary(),jobAdvertisementAddDto.getMaxSalary(),
				jobAdvertisementAddDto.getWorkingTypeId(),jobAdvertisementAddDto.getWorkingHourId(),jobAdvertisementAddDto.getNumberOfPosition(),
				jobAdvertisementAddDto.getLastDate(),jobAdvertisementAddDto.isActive(),jobAdvertisementAddDto.isConfirm());
		return jobAdvertisement;
	}

}
