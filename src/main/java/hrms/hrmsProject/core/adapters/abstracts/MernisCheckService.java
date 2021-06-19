package hrms.hrmsProject.core.adapters.abstracts;

public interface MernisCheckService {
	boolean validate(String identityNumber,String firstName,String lastName,String date);
}
