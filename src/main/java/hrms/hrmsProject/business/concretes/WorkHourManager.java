package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.WorkHourService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.WorkHourDao;
import hrms.hrmsProject.entities.concretes.WorkHour;
import lombok.var;

@Service
public class WorkHourManager implements WorkHourService{
	private WorkHourDao workHourDao;
	
	@Autowired
	public WorkHourManager(WorkHourDao workHourDao) {
		this.workHourDao=workHourDao;
	}
	
	@Override
	public DataResult<List<WorkHour>> getAll() {
		var result=this.workHourDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<WorkHour>>(result);
		}
		return new ErrorDataResult<List<WorkHour>>(ProjectMessages.noData);
	}
	
}
