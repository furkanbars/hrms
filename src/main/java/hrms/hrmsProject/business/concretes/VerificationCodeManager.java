package hrms.hrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.VerificationCodeService;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.dataAccess.abstracts.VerificationCodeDao;
import hrms.hrmsProject.entities.concretes.ActivationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{
	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		this.verificationCodeDao=verificationCodeDao;
	}
	
	@Override
	public Result add(ActivationCode activationCode) {
		verificationCodeDao.save(activationCode);
		return new SuccessResult("Aktivasyon kodu kaydedildi.");
	}

}

  