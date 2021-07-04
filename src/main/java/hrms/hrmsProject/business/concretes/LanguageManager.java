package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.LanguageService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.LanguageDao;
import hrms.hrmsProject.entities.concretes.Language;
import lombok.var;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	
	@Autowired
    public LanguageManager(LanguageDao languageDao) {
		this.languageDao=languageDao;
	}
	
	@Override
	public DataResult<List<Language>> getAll() {
		var result = this.languageDao.findAll();
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<Language>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<Language>>(ProjectMessages.errorResultMessage);
	}

}
