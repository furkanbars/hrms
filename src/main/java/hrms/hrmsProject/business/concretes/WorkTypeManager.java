package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.WorkTypeService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.WorkTypeDao;
import hrms.hrmsProject.entities.concretes.WorkType;
import lombok.var;

@Service
public class WorkTypeManager implements WorkTypeService{
	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		this.workTypeDao=workTypeDao;
	}
	
	@Override
	public DataResult<List<WorkType>> getAll() {
		var result=this.workTypeDao.findAll();
		
		if (result!=null) {
			return new SuccessDataResult<List<WorkType>>(result,"İş tipleri listelendi.");
		}
		return new ErrorDataResult<List<WorkType>>(ProjectMessages.noData);
		
	}

}
