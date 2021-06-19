package hrms.hrmsProject.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsProject.business.abstracts.JobAdvertisementService;
import hrms.hrmsProject.core.utilities.Results.DataResult;
import hrms.hrmsProject.entities.concretes.JobAdvertisement;
import hrms.hrmsProject.entities.concretes.dtos.JobAdvertisementAddDto;
import lombok.var;

@CrossOrigin
@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService=jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		var result = this.jobAdvertisementService.add(jobAdvertisementAddDto);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbyactive")
	public DataResult<List<JobAdvertisement>> getbyactive(){
		return this.jobAdvertisementService.getAllByIsActive();
	}
	
	@GetMapping("/getallbyisactiveandlastdateasc")
	public DataResult<List<JobAdvertisement>> getAllByIsActiveAndLastDateAsc(){
		return this.jobAdvertisementService.getAllByIsActiveAndLastDateAsc();
	}
	
	@GetMapping("/getbyemployerid")
	public DataResult<List<JobAdvertisement>> getByEmployerId(@RequestParam int employerId){
		return this.jobAdvertisementService.getAllByEmployerId(employerId);
	}
	
	@GetMapping("/getallnotconfirmed")
	public ResponseEntity<?> getAllNotConfirmed(){
		
	 	var result = this.jobAdvertisementService.getAllNotConfirmed();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
