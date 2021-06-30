package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CvService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.CvDao;
import hrms.hrmsProject.entities.concretes.Cv;
import lombok.var;

@Service
public class CvManager implements CvService{
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao=cvDao;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult(ProjectMessages.addedCv);
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		var result = this.cvDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Cv>>(result); 
		}
		return new ErrorDataResult<List<Cv>>(ProjectMessages.noData);
	}

	@Override
	public DataResult<Cv> getById(int id) {
		var result=this.cvDao.getById(id);
		if (result!=null) {
			return new SuccessDataResult<Cv>(result);
		}
		return new ErrorDataResult<Cv>(ProjectMessages.noData);
	}

	@Override
	public DataResult<Cv> getByJobSeekerId(int userId) {
		var result = this.cvDao.getByJobSeeker_id(userId);
		if (result!=null) {
			return new SuccessDataResult<Cv>(result,ProjectMessages.listedJobseekerCv);
		}
		return new ErrorDataResult<Cv>(ProjectMessages.noData);
	}

	
	
}
