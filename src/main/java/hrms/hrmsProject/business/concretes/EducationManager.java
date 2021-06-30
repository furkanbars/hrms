package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.EducationService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.EducationDao;
import hrms.hrmsProject.entities.concretes.Education;
import hrms.hrmsProject.entities.concretes.dtos.CvEducationAddDto;
import lombok.var;

@Service
public class EducationManager implements EducationService{
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao=educationDao;
	}
	
	@Override
	public Result add(CvEducationAddDto cvEducationAddDto) {
		var education = this.setEducation(cvEducationAddDto);
		var result = this.educationDao.save(education);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedEducation);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<Education>> getAll() {
		var result = this.educationDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Education>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<Education>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<List<Education>> getByCvId(int id) {
		var result = this.educationDao.getByCv_id(id);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Education>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<Education>>(ProjectMessages.notFoundEducation);
	}
	
	@Override
	public Result update(CvEducationAddDto cvEducationAddDto) {
		var education = setEducation(cvEducationAddDto);
		var result = this.educationDao.save(education);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.updatedEducation);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	@Override
	public Result delete(int id) {
		this.educationDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedEducation);
	}

	private Education setEducation(CvEducationAddDto cvEducationAddDto) {
		Education education=new Education(cvEducationAddDto.getCvId(),cvEducationAddDto.getGraduateId()
				,cvEducationAddDto.getSchoolId(),cvEducationAddDto.getFacultyId(),cvEducationAddDto.getStartDate(),cvEducationAddDto.getEndDate());
		return education;
	}

	
}
