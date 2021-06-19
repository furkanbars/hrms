package hrms.hrmsProject.business.abstracts;

import java.util.List;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.entities.concretes.WorkType;

public interface WorkTypeService {
	DataResult<List<WorkType>> getAll();
}
