package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.dataAccess.abstracts.JobPositionDao;
import hrms.hrmsProject.entities.concretes.Job;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao=jobPositionDao;
	}
	
	@Override
	public List<Job> GetAll() {
		return this.jobPositionDao.findAll();
	}

}
