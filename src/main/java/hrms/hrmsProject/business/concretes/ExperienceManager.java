package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.ExperienceService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.core.utilities.dtoConvertor.DtoConvertorService;
import hrms.hrmsProject.dataAccess.abstracts.ExperienceDao;
import hrms.hrmsProject.entities.concretes.Experience;
import hrms.hrmsProject.entities.concretes.dtos.CvExperienceAddDto;
import lombok.var;

@Service
public class ExperienceManager implements ExperienceService{
	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao,DtoConvertorService dtoConvertorService) {
		this.experienceDao=experienceDao;
	}

	@Override
	public Result add(CvExperienceAddDto cvExperienceAddDto) {
		var experience = setExperience(cvExperienceAddDto);
		var result = this.experienceDao.save(experience);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedExperience);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		var result=this.experienceDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<Experience>>(result);
		}
		return new ErrorDataResult<List<Experience>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<List<Experience>> getByCvId(int cvId) {
		var result = this.experienceDao.getByCv_id(cvId);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Experience>>(result,ProjectMessages.listedExperiencesByCv);
		}
		return new ErrorDataResult<List<Experience>>(ProjectMessages.noData);
	}
	
	private Experience setExperience(CvExperienceAddDto cvExperienceAddDto) {
		Experience experience=new Experience(cvExperienceAddDto.getCompanyName(),cvExperienceAddDto.getCvId(),cvExperienceAddDto.getPositionId(),
				cvExperienceAddDto.getStartDate(),cvExperienceAddDto.getEndDate());
		return experience;
	}

	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedExperience);
	}

	
}
