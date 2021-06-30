package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Technology;
import hrms.hrmsProject.entities.concretes.dtos.CvTechnologyAddDto;

public interface TechnologyService {
	Result add(CvTechnologyAddDto cvTechnologyAddDto);
	DataResult<List<Technology>> getAll();
	DataResult<Technology> getByCvId(int cvId);
	Result delete(int id);
}
