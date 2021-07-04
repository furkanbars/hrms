package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.CvTechnology;
import hrms.hrmsProject.entities.concretes.dtos.CvTechnologyAddDto;

public interface CvTechnologyService {
	Result add(CvTechnologyAddDto cvTechnologyAddDto);
	DataResult<List<CvTechnology>> getAll();
	DataResult<CvTechnology> getByCvId(int cvId);
	Result delete(int id);
	Result update(CvTechnology technology);
}
