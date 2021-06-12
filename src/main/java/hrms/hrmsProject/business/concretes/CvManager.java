package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CvService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.core.utilities.dtoConvertor.DtoConvertorService;
import hrms.hrmsProject.dataAccess.abstracts.CvDao;
import hrms.hrmsProject.entities.concretes.Cv;
import hrms.hrmsProject.entities.concretes.dtos.AddForCvDto;

@Service
public class CvManager implements CvService{
	private CvDao cvDao;
	private DtoConvertorService dtoConvertor;
	
	@Autowired
	public CvManager(CvDao cvDao,DtoConvertorService dtoConvertor) {
		super();
		this.cvDao=cvDao;
		this.dtoConvertor=dtoConvertor;
	}

	@Override
	public Result add(AddForCvDto cvDto) {
		this.cvDao.save((Cv)this.dtoConvertor.dtoClassConvertor(cvDto, Cv.class));
		return new SuccessResult(ProjectMessages.addedCv);
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll()); 
	}
	
}
