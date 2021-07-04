package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CvTechnologyService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.CvTechnologyDao;
import hrms.hrmsProject.entities.concretes.CvTechnology;
import hrms.hrmsProject.entities.concretes.dtos.CvTechnologyAddDto;
import lombok.var;

@Service
public class CvTechnologyManager implements CvTechnologyService{
	private CvTechnologyDao cvTechnologyDao;
	
	@Autowired
	public CvTechnologyManager(CvTechnologyDao cvTechnologyDao) {
		this.cvTechnologyDao=cvTechnologyDao;
	}
	
	@Override
	public Result add(CvTechnologyAddDto cvTechnologyAddDto) {
		
		var technology = setTechnology(cvTechnologyAddDto);
		
		var result = this.cvTechnologyDao.save(technology);
		
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedTechnology);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<CvTechnology>> getAll() {
		var result = this.cvTechnologyDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<CvTechnology>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<CvTechnology>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<CvTechnology> getByCvId(int cvId) {
		var result = this.cvTechnologyDao.getByCv_id(cvId);
		if (result!=null) {
			return new SuccessDataResult<CvTechnology>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<CvTechnology>(ProjectMessages.noData);
	}
	
	@Override
	public Result delete(int id) {
		this.cvTechnologyDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedTechnology);
	}

	@Override
	public Result update(CvTechnology technology) {
		var result = this.cvTechnologyDao.save(technology);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.updatedTechnology);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	private CvTechnology setTechnology(CvTechnologyAddDto cvTechnologyAddDto) {
		CvTechnology technology=new CvTechnology(cvTechnologyAddDto.getCvId(),cvTechnologyAddDto.getTechnologyName());
		return technology;
	}

	

	
	
}
