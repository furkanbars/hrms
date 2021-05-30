package hrms.hrmsProject.core.utilities.adapters.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import hrms.hrmsProject.core.utilities.adapters.abstracts.MernisCheckService;

@Service
public class MernisServiceAdapter implements MernisCheckService{

	@Override
	public boolean validate(String identityNumber, String firstName, String lastName,LocalDate date) {
		return true;
	}

}
