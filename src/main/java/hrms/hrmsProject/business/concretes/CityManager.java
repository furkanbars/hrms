package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CityService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.CityDao;
import hrms.hrmsProject.entities.concretes.City;
import lombok.var;

@Service
public class CityManager implements CityService{
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao=cityDao;
	}
	
	@Override
	public DataResult<List<City>> getAll() {
		var result=this.cityDao.findAll();
		if (result!=null) {
			return new SuccessDataResult<List<City>>(result,"Şehirler listelendi.");
		}
		return new ErrorDataResult<List<City>>(ProjectMessages.cantListedCities);
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult(ProjectMessages.addedCity);
	}
	
}
