package hrms.hrmsProject.core.utilities.adapters.abstracts;

import java.time.LocalDate;

public interface MernisCheckService {
	boolean validate(String identityNumber,String firstName,String lastName,LocalDate date);
}
