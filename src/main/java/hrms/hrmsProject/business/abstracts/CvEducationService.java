package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.CvEducation;
import hrms.hrmsProject.entities.concretes.dtos.CvEducationAddDto;

public interface CvEducationService {
	Result add(CvEducationAddDto cvEducationAddDto);
	DataResult<List<CvEducation>> getAll();
	DataResult<List<CvEducation>> getByCvId(int cvId);
	DataResult<CvEducation> getById(int id);
	Result update(CvEducation education);
	Result delete(int id);
}
