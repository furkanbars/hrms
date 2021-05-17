package hrms.hrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService=jobPositionService;
	}
	
	@GetMapping("/getall")
	public List<Job> GetAll(){
		return this.jobPositionService.GetAll();
	}
}
