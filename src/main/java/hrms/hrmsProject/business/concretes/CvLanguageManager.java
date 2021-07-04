package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CvLanguageService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.CvLanguageDao;
import hrms.hrmsProject.entities.concretes.CvLanguage;
import hrms.hrmsProject.entities.concretes.dtos.CvLanguageAddDto;
import lombok.var;

@Service
public class CvLanguageManager implements CvLanguageService{
	private CvLanguageDao cvLanguageDao;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		this.cvLanguageDao=cvLanguageDao;
	}
	
	@Override
	public Result add(CvLanguageAddDto cvLanguageAddDto) {
		var language = setLanguage(cvLanguageAddDto);
		var result = this.cvLanguageDao.save(language);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedLanguage);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		var result = this.cvLanguageDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<CvLanguage>>(result);
		}
		return new ErrorDataResult<List<CvLanguage>>(ProjectMessages.noData);
	}
	
	@Override
	public DataResult<List<CvLanguage>> getByCvId(int cvId) {
		var result = this.cvLanguageDao.getByCv_Id(cvId);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<CvLanguage>>(result,ProjectMessages.listedLanguagesByCv);
		}
		return new ErrorDataResult<List<CvLanguage>>(ProjectMessages.noData);
	}
	
	@Override
	public Result delete(int id) {
		this.cvLanguageDao.deleteById(id);
		return new SuccessResult(ProjectMessages.deletedLanguage);
	}

	@Override
	public Result update(CvLanguage language) {
		var result = this.cvLanguageDao.save(language);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.updatedLanguage);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}
	
	private CvLanguage setLanguage(CvLanguageAddDto cvLanguageAddDto) {
		CvLanguage language=new CvLanguage(cvLanguageAddDto.getCvId(),cvLanguageAddDto.getLanguageId(),cvLanguageAddDto.getLanguageLevel());
		return language;
	}

	

	
	
}
