package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobAdvertisementService;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.core.utilities.dtoConvertor.DtoConvertorService;
import hrms.hrmsProject.dataAccess.abstracts.JobAdvertisementDao;
import hrms.hrmsProject.entities.concretes.JobAdvertisement;
import hrms.hrmsProject.entities.concretes.dtos.JobAdvertisementDto;
import lombok.var;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConvertorService dtoConvertor;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, DtoConvertorService dtoConvertor) {
		this.jobAdvertisementDao=jobAdvertisementDao;
		this.dtoConvertor=dtoConvertor;
	}
	
	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		this.jobAdvertisementDao.save((JobAdvertisement)this.dtoConvertor.dtoClassConvertor(jobAdvertisementDto, JobAdvertisement.class));
		
		return new SuccessResult("İş ilanı eklendi.");
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

}
