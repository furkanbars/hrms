package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.TechnologyService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.TechnologyDao;
import hrms.hrmsProject.entities.concretes.Technology;
import hrms.hrmsProject.entities.concretes.dtos.CvTechnologyAddDto;
import lombok.var;

@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyDao technologyDao;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		this.technologyDao=technologyDao;
	}
	
	@Override
	public Result add(CvTechnologyAddDto cvTechnologyAddDto) {
		
		var technology = setTechnology(cvTechnologyAddDto);
		
		var result = this.technologyDao.save(technology);
		
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedTechnology);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		var result = this.technologyDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Technology>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<Technology>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<Technology> getByCvId(int cvId) {
		var result = this.technologyDao.getByCv_id(cvId);
		if (result!=null) {
			return new SuccessDataResult<Technology>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<Technology>(ProjectMessages.noData);
	}
	
	private Technology setTechnology(CvTechnologyAddDto cvTechnologyAddDto) {
		Technology technology=new Technology(cvTechnologyAddDto.getCvId(),cvTechnologyAddDto.getTechnologyName());
		return technology;
	}

	@Override
	public Result delete(int id) {
		this.technologyDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedTechnology);
	}

	
	
}
