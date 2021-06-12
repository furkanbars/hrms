package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Cv;
import hrms.hrmsProject.entities.concretes.dtos.AddForCvDto;

public interface CvService {
	Result add(AddForCvDto cvDto);
	DataResult<List<Cv>> getAll();
}
