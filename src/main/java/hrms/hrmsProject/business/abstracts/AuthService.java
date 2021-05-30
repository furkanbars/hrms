package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.dtos.RegisterForEmployerDto;
import hrms.hrmsProject.entities.concretes.dtos.RegisterForJobSeekerDto;

public interface AuthService {
	Result registerByJobSeeker(RegisterForJobSeekerDto registerForJobSeekerDto);
	Result registerByEmployer(RegisterForEmployerDto registerForEmployerDto);
}
