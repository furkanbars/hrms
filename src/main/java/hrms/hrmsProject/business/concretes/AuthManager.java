package hrms.hrmsProject.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrmsProject.business.abstracts.AuthService;
import hrms.hrmsProject.business.abstracts.EmployerService;
import hrms.hrmsProject.business.abstracts.JobSeekerService;
import hrms.hrmsProject.business.abstracts.UserService;
import hrms.hrmsProject.business.abstracts.VerificationCodeService;
import hrms.hrmsProject.core.utilities.Results.ErrorResult;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.core.utilities.Results.SuccessResult;
import hrms.hrmsProject.core.utilities.adapters.abstracts.MernisCheckService;
import hrms.hrmsProject.core.utilities.verification.VerificationManager;
import hrms.hrmsProject.entities.concretes.ActivationCode;
import hrms.hrmsProject.entities.concretes.Employer;
import hrms.hrmsProject.entities.concretes.JobSeeker;
import hrms.hrmsProject.entities.concretes.dtos.RegisterForEmployerDto;
import hrms.hrmsProject.entities.concretes.dtos.RegisterForJobSeekerDto;

@Service
public class AuthManager implements AuthService{
	private MernisCheckService mernisCheckService;
	private JobSeekerService jobSeekerService;
	private VerificationCodeService verificationCodeService;
	private EmployerService employerService;
	private UserService userService;
	
	@Autowired
	public AuthManager(MernisCheckService mernisCheckService,JobSeekerService jobSeekerService,VerificationCodeService verificationCodeService,EmployerService employerService,
			UserService userService) {
		this.mernisCheckService=mernisCheckService;
		this.jobSeekerService=jobSeekerService;
		this.verificationCodeService=verificationCodeService;
		this.employerService=employerService;
		this.userService=userService;
	}

	@Override
	public Result registerByJobSeeker(RegisterForJobSeekerDto registerForJobSeekerDto) {
		if (!checkIfNullAreaForJobSeeker(registerForJobSeekerDto)) {
			return new ErrorResult("Boş alan bırakılamaz!");
		}
		if (!checkIfRealPerson(registerForJobSeekerDto.getIdentityNumber(), registerForJobSeekerDto.getFirstName(), registerForJobSeekerDto.getLastName(), 
				registerForJobSeekerDto.getBirthDate())) {
			return new ErrorResult("Bu TC kimlik numarasına sahip kişi bulunamadı!");
		}
		if (checkIfIdentityNumberExist(registerForJobSeekerDto.getIdentityNumber())) {
			return new ErrorResult("Bu TC kimlik numarası zaten mevcut!");
		}
		if (checkIfEmailExist(registerForJobSeekerDto.getEmail())) {
			return new ErrorResult("Bu email zaten mevcut!");
		}
		if (registerForJobSeekerDto.getPassword()!=registerForJobSeekerDto.getPasswordRep()) {
			return new ErrorResult("Parola doğrulama hatalı!");
		}
		JobSeeker jobSeeker=setJobSeeker(registerForJobSeekerDto);
		this.jobSeekerService.add(jobSeeker);
	 	String code = VerificationManager.sendCode();
		verificationCodeRecord(code,jobSeeker.getUserId(),registerForJobSeekerDto.getEmail());
		return new SuccessResult("Kayıt olundu.");
	}
	
	@Override
	public Result registerByEmployer(RegisterForEmployerDto registerForEmployerDto) {
		if (!checkIfNullAreaForEmployer(registerForEmployerDto)) {
			return new ErrorResult("Boş alan bırakılamaz!");
		}
		if (checkIfEmailExist(registerForEmployerDto.getEmail())) {
			return new ErrorResult("Bu email adresi zaten mevcut!");
		}
		if (registerForEmployerDto.getPassword()!=registerForEmployerDto.getPasswordRep()) {
			return new ErrorResult("Parola doğrulama hatası!");
		}
		if (!checkIfSameWebSiteAndDomane(registerForEmployerDto.getWebSite(),registerForEmployerDto.getEmail())) {
			return new ErrorResult("Web sitesi ile email aynı değil!");
		}
		Employer employer = setEmployer(registerForEmployerDto);
		employerService.add(employer);
		String code = VerificationManager.sendCode();
		verificationCodeRecord(code, employer.getUserId(),registerForEmployerDto.getEmail());                                                                             
		return new SuccessResult("Kayıt olundu!");
	}
	
	private boolean checkIfNullAreaForEmployer(RegisterForEmployerDto registerForEmployerDto) {
		if (registerForEmployerDto.getEmail()!=null && registerForEmployerDto.getCompanyName()!=null && registerForEmployerDto.getPhoneNumber()!=null
				&& registerForEmployerDto.getWebSite()!=null && registerForEmployerDto.getPassword()!=null && registerForEmployerDto.getPassword()!=null) {
			return true;
		}
		return false;
	}
	private boolean checkIfSameWebSiteAndDomane(String webSite,String email) {
		if (webSite!=email) {
			return false;
		}
		return true;
	}
	
	private boolean checkIfEmailExist(String email) {
		if (userService.getByEmail(email).isSuccess()) {
			return true;
		}
		return false;
	}
	private Employer setEmployer(RegisterForEmployerDto registerForEmployerDto) {
		Employer employer=new Employer();
		employer.setWebAddress(registerForEmployerDto.getWebSite());
		employer.setCompanyName(registerForEmployerDto.getCompanyName());
		employer.setPhoneNumber(Long.parseLong(registerForEmployerDto.getPhoneNumber())); 
		return employer;
	}
	
	private boolean checkIfNullAreaForJobSeeker(RegisterForJobSeekerDto registerForJobSeekerDto) {
		if (registerForJobSeekerDto.getEmail()!=null && registerForJobSeekerDto.getFirstName()!=null && registerForJobSeekerDto.getLastName()!=null
				&& registerForJobSeekerDto.getIdentityNumber()!=null && registerForJobSeekerDto.getBirthDate()!=null && registerForJobSeekerDto.getPassword()!=null
				&& registerForJobSeekerDto.getPasswordRep()!=null) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfRealPerson(String identityNumber,String firstName,String lastName,LocalDate date) {
		if (mernisCheckService.validate(identityNumber, firstName, lastName, date)) {
			return true;
		}
		return false;
	}
	private boolean checkIfIdentityNumberExist(String identityNumber) {
		if (jobSeekerService.getByIdentityNumber(identityNumber).isSuccess()) {
			return true;
		}
		return false;
	}
	
	private JobSeeker setJobSeeker(RegisterForJobSeekerDto registerForJobSeekerDto) {
		JobSeeker jobSeeker=new JobSeeker();
		jobSeeker.setIdentityNumber(registerForJobSeekerDto.getIdentityNumber());
		jobSeeker.setFirstName(registerForJobSeekerDto.getFirstName());
		jobSeeker.setLastName(registerForJobSeekerDto.getLastName());
		jobSeeker.setBirthDate(registerForJobSeekerDto.getBirthDate());
		return jobSeeker;
	}
	private void verificationCodeRecord(String code,int userId,String email) {
		ActivationCode activationCode=new ActivationCode(userId,code,LocalDate.now());
		this.verificationCodeService.add(activationCode);
		System.out.println("Doğrulama kodu "+email+" adresine gönderildi.");
	}

	
}
