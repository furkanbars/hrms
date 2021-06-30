package hrms.hrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.CityService;
import hrms.hrmsProject.business.constants.ProjectMessages;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
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
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<City>>(result,ProjectMessages.listedCities);
		}
		return new ErrorDataResult<List<City>>(ProjectMessages.notFoundCity);
	}

	@Override
	public Result add(City city) {
		var result = this.cityDao.save(city);
		if (result!=null) {
			return new SuccessResult(ProjectMessages.addedCity);
		}
		return new ErrorResult(ProjectMessages.errorResultMessage);
	}

	@Override
	public DataResult<List<City>> getByCountryId(int id) {
		var result = this.cityDao.getByCountry_Id(id);
		if (!result.isEmpty()) {
			return new SuccessDataResult<List<City>>(result,ProjectMessages.successResultMessage);
		}
		return new ErrorDataResult<List<City>>(ProjectMessages.errorResultMessage);
	}
	
}
