package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.LanguageService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.LanguageDao;
import hrms.hrmsProject.entities.concretes.Language;
import hrms.hrmsProject.entities.concretes.dtos.CvLanguageAddDto;
import lombok.var;

@Service
public class LanguageManager implements LanguageService{
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao=languageDao;
	}
	
	@Override
	public Result add(CvLanguageAddDto cvLanguageAddDto) {
		var language = setLanguage(cvLanguageAddDto);
		var result = this.languageDao.save(language);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedLanguage);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<Language>> getAll() {
		var result = this.languageDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<Language>>(result);
		}
		return new ErrorDataResult<List<Language>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<List<Language>> getByCvId(int cvId) {
		var result = this.languageDao.getByCv_Id(cvId);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Language>>(result,ProjectMessages.listedLanguagesByCv);
		}
		return new ErrorDataResult<List<Language>>(ProjectMessages.noData);
	}
	
	private Language setLanguage(CvLanguageAddDto cvLanguageAddDto) {
		Language language=new Language(cvLanguageAddDto.getCvId(),cvLanguageAddDto.getLanguageName(),cvLanguageAddDto.getLanguageLevel());
		return language;
	}

	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedLanguage);
	}

	
	
}
