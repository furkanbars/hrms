package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CvEducationService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.CvEducationDao;
import hrms.hrmsProject.entities.concretes.dtos.CvEducationAddDto;
import hrms.hrmsProject.entities.concretes.CvEducation;
import lombok.var;

@Service
public class CvEducationManager implements CvEducationService{
	private CvEducationDao cvEducationDao;
	
	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) {
		this.cvEducationDao=cvEducationDao;
	}
	
	@Override
	public Result add(CvEducationAddDto cvEducationAddDto) {
		var education = this.setEducation(cvEducationAddDto);
		var result = this.cvEducationDao.save(education);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedEducation);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		var result = this.cvEducationDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<CvEducation>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<CvEducation>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<List<CvEducation>> getByCvId(int cvId) {
		var result = this.cvEducationDao.getByCv_id(cvId);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<CvEducation>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<CvEducation>>(ProjectMessages.notFoundEducation);
	}
	
	@Override
	public Result update(CvEducation education) {
		var result = this.cvEducationDao.save(education);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.updatedEducation);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	@Override
	public Result delete(int id) {
		this.cvEducationDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedEducation);
	}

	@Override
	public DataResult<CvEducation> getById(int id) {
		var result = this.cvEducationDao.getById(id);
		if (result!=null){
			return new SuccessDataResult<CvEducation>(result,ProjectMessages.listedEducation);
		}
		return new ErrorDataResult<CvEducation>(ProjectMessages.noData);
	}
	
	private CvEducation setEducation(CvEducationAddDto cvEducationAddDto) {
		CvEducation education=new CvEducation(cvEducationAddDto.getCvId(),cvEducationAddDto.getGraduateId()
				,cvEducationAddDto.getSchoolId(),cvEducationAddDto.getFacultyId(),cvEducationAddDto.getDepartmentId(),cvEducationAddDto.getStartDate(),cvEducationAddDto.getEndDate());
		return education;
	}


	
}
