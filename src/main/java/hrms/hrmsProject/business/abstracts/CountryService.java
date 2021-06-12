package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.entities.concretes.Country;

public interface CountryService {
	DataResult<List<Country>> getAll();
}
