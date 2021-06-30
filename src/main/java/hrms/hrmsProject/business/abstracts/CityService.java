package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
	DataResult<List<City>> getByCountryId(int id);
}
