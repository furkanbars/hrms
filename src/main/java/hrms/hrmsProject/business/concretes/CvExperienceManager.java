package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CvExperienceService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.CvExperienceDao;
import hrms.hrmsProject.entities.concretes.CvExperience;
import hrms.hrmsProject.entities.concretes.dtos.CvExperienceAddDto;
import lombok.var;

@Service
public class CvExperienceManager implements CvExperienceService{
	private CvExperienceDao cvExperienceDao;
	
	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		this.cvExperienceDao=cvExperienceDao;
	}

	@Override
	public Result add(CvExperienceAddDto cvExperienceAddDto) {
		var experience = setExperience(cvExperienceAddDto);
		var result = this.cvExperienceDao.save(experience);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedExperience);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<CvExperience>> getAll() {
		var result=this.cvExperienceDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<CvExperience>>(result);
		}
		return new ErrorDataResult<List<CvExperience>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<List<CvExperience>> getByCvId(int cvId) {
		var result = this.cvExperienceDao.getByCv_id(cvId);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<CvExperience>>(result,ProjectMessages.listedExperiencesByCv);
		}
		return new ErrorDataResult<List<CvExperience>>(ProjectMessages.noData);
	}
	
	@Override
	public Result delete(int id) {
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedExperience);
	}

	@Override
	public Result update(CvExperience experience) {
		var result = this.cvExperienceDao.save(experience);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.updatedExperiance);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	private CvExperience setExperience(CvExperienceAddDto cvExperienceAddDto) {
		CvExperience experience=new CvExperience(cvExperienceAddDto.getCompanyName(),cvExperienceAddDto.getCvId(),cvExperienceAddDto.getPositionId(),
				cvExperienceAddDto.getWorkTypeId(),cvExperienceAddDto.getCityId(),cvExperienceAddDto.getDescription(),cvExperienceAddDto.getStartDate(),cvExperienceAddDto.getEndDate());
		return experience;
	}

	

	
}
