package hrms.hrmsProject.business.abstracts;

import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.ActivationCode;

public interface VerificationCodeService {
	Result add(ActivationCode activationCode);
}
