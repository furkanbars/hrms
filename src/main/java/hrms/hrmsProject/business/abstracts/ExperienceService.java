package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Experience;
import hrms.hrmsProject.entities.concretes.dtos.CvExperienceAddDto;

public interface ExperienceService {
	Result add(CvExperienceAddDto cvExperienceAddDto);
	DataResult<List<Experience>> getAll();
	DataResult<List<Experience>> getByCvId(int cvId);
	Result delete(int id);
}
