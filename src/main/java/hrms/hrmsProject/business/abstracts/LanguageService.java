package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Language;
import hrms.hrmsProject.entities.concretes.dtos.CvLanguageAddDto;

public interface LanguageService {
	Result add(CvLanguageAddDto cvLanguageAddDto);
	DataResult<List<Language>> getAll();
	DataResult<List<Language>> getByCvId(int cvId);
	Result delete(int id);
}
