package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.CvLanguage;
import hrms.hrmsProject.entities.concretes.dtos.CvLanguageAddDto;

public interface CvLanguageService {
	Result add(CvLanguageAddDto cvLanguageAddDto);
	DataResult<List<CvLanguage>> getAll();
	DataResult<List<CvLanguage>> getByCvId(int cvId);
	Result delete(int id);
	Result update(CvLanguage language);
}
