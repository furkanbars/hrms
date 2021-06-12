package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CountryService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.CountryDao;
import hrms.hrmsProject.entities.concretes.Country;
import lombok.var;

@Service
public class CountryManager implements CountryService{

	private CountryDao countryDao;
	
	@Autowired
	public CountryManager(CountryDao countryDao) {
		this.countryDao=countryDao;
	}
	
	@Override
	public DataResult<List<Country>> getAll() {
		var result=this.countryDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<Country>>(result,ProjectMessages.listedCountries);
		}
		return new ErrorDataResult<List<Country>>(ProjectMessages.cantListedCountries);
	}

}
