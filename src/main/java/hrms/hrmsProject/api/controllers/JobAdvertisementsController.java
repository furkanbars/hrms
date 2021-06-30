package hrms.hrmsProject.api.controllers;

import javax.transaction.Transactional;
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
	public ResponseEntity<?> getAll(){
		var result = this.jobAdvertisementService.getAllByIsActiveAndIsConfirmAndLastDateAsc();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getallnormal")
	public ResponseEntity<?> getAllNormal() {
		var result=this.jobAdvertisementService.getAll();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getallsorted")
	public ResponseEntity<?> getAllSorted(@RequestParam int pageNo,@RequestParam int pageSize){
		var result = this.jobAdvertisementService.getAllSorted(pageNo,pageSize);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
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
	public ResponseEntity<?> getAllByIsActive(){
		var result=this.jobAdvertisementService.getAllByIsActive();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);		
	}
	
	@GetMapping("/getallbyisactiveandlastdateasc")
	public ResponseEntity<?> getAllByIsActiveAndLastDateAsc(){
		var result = this.jobAdvertisementService.getAllByIsActiveAndLastDateAsc();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(@RequestParam int id){
		var result=this.jobAdvertisementService.getById(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getbyemployerid")
	public ResponseEntity<?> getByEmployerId(@RequestParam int employerId){
		var result=this.jobAdvertisementService.getById(employerId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@GetMapping("/getallnotconfirmed")
	public ResponseEntity<?> getAllNotConfirmed(){
		
	 	var result = this.jobAdvertisementService.getAllNotConfirmed();
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@GetMapping("/updateconfirmstatus")
	public ResponseEntity<?> updateConfirmStatus(@RequestParam int id){
		var result = this.jobAdvertisementService.updateConfirmStatus(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
	
	@Transactional
	@GetMapping("/updateisactive")
	public ResponseEntity<?> updateIsActive(@RequestParam int id){
		var result = this.jobAdvertisementService.updateIsActive(id);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.badRequest().body(result);
	}
}
