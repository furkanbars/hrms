package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.AuthService;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.dtos.RegisterForEmployerDto;
import hrms.hrmsProject.entities.concretes.dtos.RegisterForJobSeekerDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService=authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerForEmployer(@RequestBody RegisterForEmployerDto registerForEmployerDto) {
		return authService.registerByEmployer(registerForEmployerDto);
	}
	
	@PostMapping("/registerJobSeeker")
	public Result registerForJobSeeker(@RequestBody RegisterForJobSeekerDto registerForJobSeekerDto) {
		return authService.registerByJobSeeker(registerForJobSeekerDto);
	}
}
