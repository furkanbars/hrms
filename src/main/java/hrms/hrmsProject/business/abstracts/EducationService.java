package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Education;
import hrms.hrmsProject.entities.concretes.dtos.CvEducationAddDto;

public interface EducationService {
	Result add(CvEducationAddDto cvEducationAddDto);
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> getByCvId(int id);
	Result update(CvEducationAddDto cvEducationAddDto);
	Result delete(int id);
}
