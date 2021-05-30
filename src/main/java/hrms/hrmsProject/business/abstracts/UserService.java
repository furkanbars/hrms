package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.entities.concretes.User;

public interface UserService {
	DataResult<User> getByEmail(String email);
}
