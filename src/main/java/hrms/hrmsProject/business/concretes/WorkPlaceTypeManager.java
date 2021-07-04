package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.WorkPlaceTypeService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.WorkPlaceTypeDao;
import hrms.hrmsProject.entities.concretes.WorkPlaceType;
import lombok.var;

@Service
public class WorkPlaceTypeManager implements WorkPlaceTypeService{
	private WorkPlaceTypeDao workPlaceTypeDao;
	
	@Autowired
	public WorkPlaceTypeManager(WorkPlaceTypeDao workPlaceTypeDao) {
		this.workPlaceTypeDao=workPlaceTypeDao;
	}
	
	@Override
	public DataResult<List<WorkPlaceType>> getAll() {
		var result=this.workPlaceTypeDao.findAll();
		
		if (result!=null) {
			return new SuccessDataResult<List<WorkPlaceType>>(result,"İş tipleri listelendi.");
		}
		return new ErrorDataResult<List<WorkPlaceType>>(ProjectMessages.noData);
		
	}

}
