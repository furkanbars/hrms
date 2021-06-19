package hrms.hrmsProject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.JobPositionService;
import hrms.hrmsProject.core.utilities.Results.Result;
import hrms.hrmsProject.entities.concretes.Job;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService=jobPositionService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?>getAll(){
		var result=this.jobPositionService.GetAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result); 
		}else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		 return this.jobPositionService.Add(job);
	}
}
