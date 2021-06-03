package hrms.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.UserService;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.core.utilities.Results.ErrorDataResult;
import hrms.hrmsProject.core.utilities.Results.SuccessDataResult;
import hrms.hrmsProject.dataAccess.abstracts.UserDao;
import hrms.hrmsProject.entities.concretes.User;
import lombok.var;

@Service
public class UserManager implements UserService {
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao=userDao;
	}
	@Override
	public DataResult<User> getByEmail(String email) {
		var result=userDao.getByEmail(email);
		if (result!=null) {
			return new SuccessDataResult<User>(result);
		}
		return new ErrorDataResult<User>("Email bulunamadı!");
	}

}
