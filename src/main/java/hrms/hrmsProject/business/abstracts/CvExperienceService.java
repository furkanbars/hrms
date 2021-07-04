package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.CvExperience;
import hrms.hrmsProject.entities.concretes.dtos.CvExperienceAddDto;

public interface CvExperienceService {
	Result add(CvExperienceAddDto cvExperienceAddDto);
	DataResult<List<CvExperience>> getAll();
	DataResult<List<CvExperience>> getByCvId(int cvId);
	Result delete(int id);
	Result update(CvExperience experience);
}
